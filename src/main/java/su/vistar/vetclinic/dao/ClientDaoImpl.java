package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Client;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    @Override
    public Client findById(int id) {
        Client client = getByKey(id);

        if (client != null) {
            Hibernate.initialize(client.getAccount());
            Hibernate.initialize(client.getRoles());
        }

        return client;
    }

    @Override
    public Client findByLogin(String login) {
        Criteria criteria = createEntityCriteria();

        criteria.createAlias("account", "account");
        criteria.add(Restrictions.eq("account.login", login));
        criteria.setMaxResults(1);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        Client client = (Client) criteria.uniqueResult();

        if (client != null) {
            Hibernate.initialize(client.getRoles());
            Hibernate.initialize(client.getAnimals());
            Hibernate.initialize(client.getAccount());
        }

        return client;
    }
}
