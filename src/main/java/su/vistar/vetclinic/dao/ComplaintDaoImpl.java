package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.model.Complaint;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Repository("complaintDao")
public class ComplaintDaoImpl extends AbstractDao<Integer, Complaint> implements ComplaintDao {

    @Override
    public Complaint findById(int id) {
        Complaint complaint = getByKey(id);

        if (complaint != null) {
            Hibernate.initialize(complaint.getAnimal());
            Hibernate.initialize(complaint.getEmployee());
            Hibernate.initialize(complaint.getStatus());
        }

        return complaint;
    }

    @Override
    @SuppressWarnings({ "unchecked", "Duplicates" })
    public List<Complaint> findAllByAnimalId(int animalId) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("animal.id", animalId));
        criteria.addOrder(Order.desc("date"));

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List<Complaint> result = (List<Complaint>) criteria.list();

        for (Complaint complaint : result) {
            complaint.setAnimal(initializeAndUnProxy(complaint.getAnimal()));
            complaint.setStatus(initializeAndUnProxy(complaint.getStatus()));

            complaint.setEmployee(initializeAndUnProxy(complaint.getEmployee()));
            complaint.getEmployee().setRoles(initializeAndUnProxy(complaint.getEmployee().getRoles()));
        }

        return result;
    }

    @Override
    @SuppressWarnings({ "unchecked", "Duplicates" })
    public List<Complaint> findThreeLastComplaintByEmployeeId(int employeeId) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("employee.id", employeeId));
        criteria.addOrder(Order.desc("date"));
        criteria.setMaxResults(3);

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List<Complaint> result = (List<Complaint>) criteria.list();

        for (Complaint complaint : result) {
            complaint.setAnimal(initializeAndUnProxy(complaint.getAnimal()));
            complaint.setStatus(initializeAndUnProxy(complaint.getStatus()));

            complaint.setEmployee(initializeAndUnProxy(complaint.getEmployee()));
            complaint.getEmployee().setRoles(initializeAndUnProxy(complaint.getEmployee().getRoles()));
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Complaint findLastComplaintByAnimalId(int animalId) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("animal.id", animalId));
        criteria.addOrder(Order.desc("date"));
        criteria.setMaxResults(1);

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        Complaint result = (Complaint) criteria.uniqueResult();

        if (result != null) {
            result.setAnimal(initializeAndUnProxy(result.getAnimal()));

            result.setEmployee(initializeAndUnProxy(result.getEmployee()));
            result.getEmployee().setRoles(initializeAndUnProxy(result.getEmployee().getRoles()));

            result.setStatus(initializeAndUnProxy(result.getStatus()));
        }


        return result;
    }

    @Override
    public Integer getComplaintsCountByAnimalId(int animalId) {
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("animal.id", animalId));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return criteria.list().size();
    }
}
