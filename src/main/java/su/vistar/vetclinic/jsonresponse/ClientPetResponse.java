package su.vistar.vetclinic.jsonresponse;

import su.vistar.vetclinic.model.Animal;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */
public class ClientPetResponse {

    private Animal animal;
    private int complainsCount;
    private String lastComplaintStatus;

    public ClientPetResponse(Animal animal, int complainsCount, String lastComplaintStatus) {
        this.animal = animal;
        this.complainsCount = complainsCount;
        this.lastComplaintStatus = lastComplaintStatus;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getComplainsCount() {
        return complainsCount;
    }

    public void setComplainsCount(int complainsCount) {
        this.complainsCount = complainsCount;
    }

    public String getLastComplaintStatus() {
        return lastComplaintStatus;
    }

    public void setLastComplaintStatus(String lastComplaintStatus) {
        this.lastComplaintStatus = lastComplaintStatus;
    }
}
