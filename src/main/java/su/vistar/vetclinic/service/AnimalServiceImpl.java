package su.vistar.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.dao.AnimalDao;
import su.vistar.vetclinic.model.Animal;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDao dao;

    @Override
    public Animal findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Animal> findAllAnimals() {
        return dao.findAllAnimals();
    }

    @Override
    public List<Animal> findAllAnimalsByClientId(int clientId) {
        return dao.findAllAnimalsByClientId(clientId);
    }

    @Override
    public boolean isAnimalBelongToClient(int clientId, int animalId) {
        return dao.isAnimalBelongToClient(clientId, animalId);
    }
}
