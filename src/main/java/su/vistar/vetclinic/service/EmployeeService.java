package su.vistar.vetclinic.service;

import su.vistar.vetclinic.model.Employee;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */
public interface EmployeeService {

    Employee findByLogin(String login);
}
