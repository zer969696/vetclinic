package su.vistar.vetclinic.service;

import su.vistar.vetclinic.model.Client;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
public interface ClientService {

    Client findById(int id);

    Client findByLogin(String login);
}
