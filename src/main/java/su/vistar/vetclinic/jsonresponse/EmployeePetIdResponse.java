package su.vistar.vetclinic.jsonresponse;

import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Complaint;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 23.03.17.
 * VIstar
 */
public class EmployeePetIdResponse {

    private Animal animal;
    private List<Complaint> complaints;

    public EmployeePetIdResponse(Animal animal, List<Complaint> complaints) {
        this.animal = animal;
        this.complaints = complaints;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}
