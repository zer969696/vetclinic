package su.vistar.vetclinic.dao;

import su.vistar.vetclinic.model.Animal;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
public interface AnimalDao {

    Animal findById(int id);

    List<Animal> findAllAnimals();
    
    List<Animal> findAllAnimalsByClientId(int clientId);

    boolean isAnimalBelongToClient(int clientId, int animalId);
}
