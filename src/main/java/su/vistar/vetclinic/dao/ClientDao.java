package su.vistar.vetclinic.dao;

import su.vistar.vetclinic.model.Client;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
public interface ClientDao {

    Client findById(int id);

    Client findByLogin(String login);
}
