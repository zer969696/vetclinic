package su.vistar.vetclinic.security.converter;

import su.vistar.vetclinic.model.Role;
import su.vistar.vetclinic.security.model.CustomUser;

import java.util.Set;

/**
 * Created by Evgeniy Evzerov on 20.03.17.
 * VIstar
 */

public class UserRoleConverter {

    @SuppressWarnings("Duplicates")
    public String[] convertClientRolesArray(CustomUser customUser) {
        Set<Role> clientRoles = customUser.getRoles();
        Role[] clientRolesArray = clientRoles.toArray(new Role[clientRoles.size()]);

        String[] clientType = new String[clientRolesArray.length];
        for (int i = 0; i < clientRolesArray.length; i++){
            clientType[i] = clientRolesArray[i].getDescription();
        }

        return clientType;
    }

    public String toString(String[] roles) {
        String type = "";

        for (int i = 0; i < roles.length; i++) {

            if (i < 0) {
                type += roles[i];
            } else {
                if (i + 1 == roles.length){
                    type += roles[i];
                } else {
                    type += roles[i] + " ";
                }
            }
        }

        return type;
    }
}
