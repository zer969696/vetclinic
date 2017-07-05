package su.vistar.vetclinic.security.dao;

import su.vistar.vetclinic.model.Client;
import su.vistar.vetclinic.model.Employee;
import su.vistar.vetclinic.security.model.CustomUser;
import su.vistar.vetclinic.service.ClientService;
import su.vistar.vetclinic.service.EmployeeService;

/**
 * Created by Evgeniy Evzerov on 20.03.17.
 * VIstar
 */
public class CustomUserDao {

    private ClientService clientService;
    private EmployeeService employeeService;

    public CustomUserDao(ClientService clientService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    public CustomUser getCustomUser(String login) {
        Client client = clientService.findByLogin(login);

        if (client == null) {
            Employee employee = employeeService.findByLogin(login);

            if (employee == null) {
                return null;
            }

            return new CustomUser(
                    employee.getAccount().getLogin(), employee.getAccount().getPassword(), employee.getRoles()
            );
        } else {

            return new CustomUser(
                    client.getAccount().getLogin(), client.getAccount().getPassword(), client.getRoles()
            );
        }
    }
}
