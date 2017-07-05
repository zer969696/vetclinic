package su.vistar.vetclinic.jsonresponse;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Complaint;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */
public class ClientPetIdResponse {

    private Animal animal;
    private List<Complaint> complaints;

    public ClientPetIdResponse(List<Complaint> complaints, Animal animal) {
        this.complaints = complaints;
        this.animal = animal;
    }

    public ClientPetIdResponse() {
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
