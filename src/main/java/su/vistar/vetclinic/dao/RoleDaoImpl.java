package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import su.vistar.vetclinic.model.Role;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 16.03.17.
 * VIstar
 */

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Role>) criteria.list();
    }

    @Override
    public Role findById(int id) {
        return getByKey(id);
    }

    @Override
    public Role findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("description", type));

        return (Role) criteria.uniqueResult();
    }
}
