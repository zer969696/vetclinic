package su.vistar.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.dao.ClientDao;
import su.vistar.vetclinic.model.Client;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao dao;

    @Override
    public Client findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Client findByLogin(String login) {
        return dao.findByLogin(login);
    }
}
