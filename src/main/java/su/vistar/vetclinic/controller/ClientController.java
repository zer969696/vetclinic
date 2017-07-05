package su.vistar.vetclinic.controller;

import com.mongodb.gridfs.CLI;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import su.vistar.vetclinic.jsonresponse.ClientPetIdResponse;
import su.vistar.vetclinic.jsonresponse.ClientPetResponse;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Client;
import su.vistar.vetclinic.model.Complaint;
import su.vistar.vetclinic.service.AnimalService;
import su.vistar.vetclinic.service.ClientService;
import su.vistar.vetclinic.service.ComplaintService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> lastComplaint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.findByLogin(auth.getName());

        List<Animal> animals = client.getAnimals();
        List<Complaint> complaints = new ArrayList<>();
        for(Animal animal : animals) {
            complaints.add(complaintService.findLastComplaintByAnimalId(animal.getId()));
        }

        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    public ResponseEntity<List<ClientPetResponse>> allAnimals() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.findByLogin(auth.getName());

        List<Animal> clientAnimals = client.getAnimals();
        List<ClientPetResponse> jsonResponse = new ArrayList<>();

        for (Animal animal : clientAnimals) {
            String tmpLastComplaintStatus = complaintService.
                    findLastComplaintByAnimalId(animal.getId()).getStatus().getDescription();

            jsonResponse.add(new ClientPetResponse(
                    animal,
                    complaintService.getComplaintsCountByAnimalId(animal.getId()),
                    tmpLastComplaintStatus)
            );
        }

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> petInfo(@PathVariable Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.findByLogin(auth.getName());

        if (animalService.isAnimalBelongToClient(client.getId(), id)) {

            ClientPetIdResponse jsonResponse = new ClientPetIdResponse(
                    complaintService.findAllByAnimalId(id), animalService.findById(id)
            );

            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

