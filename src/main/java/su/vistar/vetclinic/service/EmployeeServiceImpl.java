package su.vistar.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.dao.EmployeeDao;
import su.vistar.vetclinic.model.Employee;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public Employee findByLogin(String login) {
        return dao.findByLogin(login);
    }
}
