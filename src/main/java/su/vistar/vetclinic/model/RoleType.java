package su.vistar.vetclinic.model;

/**
 * Created by Evgeniy Evzerov on 16.03.17.
 * VIstar
 */

public enum RoleType {

    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE"),
    CLIENT("CLIENT");

    String userRoleType;

    RoleType(String userRole){
        this.userRoleType = userRole;
    }

    public String getUserProfileType(){
        return userRoleType;
    }

}