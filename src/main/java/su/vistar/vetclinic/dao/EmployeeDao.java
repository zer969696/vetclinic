package su.vistar.vetclinic.dao;

import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Employee;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */
public interface EmployeeDao {

    Employee findById(int id);

    Employee findByLogin(String login);
}
