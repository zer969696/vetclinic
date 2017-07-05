package su.vistar.vetclinic.security.model;

import su.vistar.vetclinic.model.Role;

import java.util.Set;

/**
 * Created by Evgeniy Evzerov on 20.03.17.
 * VIstar
 */
public class CustomUser {

    private String login;
    private String password;
    private Set<Role> roles;

    public CustomUser(String login, String password, Set<Role> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
