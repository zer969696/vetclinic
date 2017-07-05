package su.vistar.vetclinic.dao;

import su.vistar.vetclinic.model.Role;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 16.03.17.
 * VIstar
 */
public interface RoleDao {

    List<Role> findAll();

    Role findById(int id);

    Role findByType(String type);
}
