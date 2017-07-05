package su.vistar.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import su.vistar.vetclinic.elasticsearch.model.Article;
import su.vistar.vetclinic.elasticsearch.model.Author;
import su.vistar.vetclinic.elasticsearch.service.ArticleService;
import su.vistar.vetclinic.jsonresponse.EmployeePetIdResponse;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Complaint;
import su.vistar.vetclinic.model.Employee;
import su.vistar.vetclinic.service.AnimalService;
import su.vistar.vetclinic.service.ComplaintService;
import su.vistar.vetclinic.service.EmployeeService;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AnimalService animalService;
//
//    @Autowired
//    private ESAnimalService esAnimalService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> lastThreeComplaints() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.findByLogin(auth.getName());

        List<Complaint> complaints = complaintService.findThreeLastComplaintByEmployeeId(employee.getId());

        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    public ResponseEntity<List<Animal>> getAllAnimals() {

        return new ResponseEntity<>(animalService.findAllAnimals(), HttpStatus.OK);
    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> petInfo(@PathVariable Integer id) {

        EmployeePetIdResponse jsonResponse = new EmployeePetIdResponse(
                animalService.findById(id), complaintService.findAllByAnimalId(id)
        );

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/pet/{id}/edit", method = RequestMethod.GET)
    public ResponseEntity<?> getPetInfo(@PathVariable Integer id) {

        return new ResponseEntity<>(animalService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/pet/{id}/edit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> editPet(@PathVariable Integer id) {

    //ToDo tyt
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() {
//        Article article = new Article("testovoe");
//        article.setAuthors(asList(new Author("John Smith"), new Author("John Doe")));
//        articleService.save(article);

//        String nameToFind = "John Smith";
//        Page<Article> articleByAuthorName
//                = articleService.findByAuthorName(nameToFind, new PageRequest(0, 10));

        List<Article> articles = articleService.findAllByAuthorsName("Eugene");


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
