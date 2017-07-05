package su.vistar.vetclinic.security.jwt;

/**
 * Created by Evgeniy Evzerov on 15.03.17.
 * VIstar
 */
public class AccountCredentials {

    private String username;
    private String password;

    String getUsername() { return username; }
    String getPassword() { return password; }

    public void setUsername(String _username) { this.username = _username; }
    public void setPassword(String _password) { this.password = _password; }
}