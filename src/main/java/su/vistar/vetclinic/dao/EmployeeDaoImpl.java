package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import su.vistar.vetclinic.model.Animal;
import su.vistar.vetclinic.model.Client;
import su.vistar.vetclinic.model.Employee;

/**
 * Created by Evgeniy Evzerov on 17.03.17.
 * VIstar
 */

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

    @Override
    public Employee findById(int id) {
        Employee employee = getByKey(id);

        if (employee != null) {
            Hibernate.initialize(employee.getAccount());
            Hibernate.initialize(employee.getRoles());
        }

        return employee;
    }

    @Override
    public Employee findByLogin(String login) {
        Criteria criteria = createEntityCriteria();

        criteria.createAlias("account", "account");
        criteria.add(Restrictions.eq("account.login", login));
        criteria.setMaxResults(1);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        Employee employee = (Employee) criteria.uniqueResult();

        if (employee != null) {
            employee.setAccount(initializeAndUnProxy(employee.getAccount()));
            employee.setRoles(initializeAndUnProxy(employee.getRoles()));
        }

        return employee;
    }
}
