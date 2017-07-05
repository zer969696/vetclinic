package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Repository;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Client;
import su.vistar.vetclinic.model.Role;
import su.vistar.vetclinic.service.ClientService;
import su.vistar.vetclinic.utilities.HibernateUtilities;

import java.util.List;
import java.util.Set;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Repository("animalDao")
public class AnimalDaoImpl extends AbstractDao<Integer, Animal> implements AnimalDao {

    @Override
    public Animal findById(int id) {
        Animal animal = getByKey(id);

        return animal;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Animal> findAllAnimals() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return (List<Animal>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Animal> findAllAnimalsByClientId(int clientId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("clientId", clientId));

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List<Animal> animals = (List<Animal>) criteria.list();

//        for (Pet animal : animals) {
//            Hibernate.initialize(animal.getClient());
//            Hibernate.initialize(animal.getClient().getAccount());
//            Hibernate.initialize(animal.getClient().getRoles());
//        }

        return animals;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isAnimalBelongToClient(int clientId, int animalId) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("clientId", clientId));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List<Animal> animals = (List<Animal>) criteria.list();
        for (Animal animal : animals) {
            if (animal.getId().equals(animalId)) {
                return true;
            }
        }

        return false;
    }
}
