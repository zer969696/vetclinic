package su.vistar.vetclinic.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
@Entity
@Table(name = "client_accounts", schema = "vetclinic")
public class ClientAccounts {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    private String login;

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;

//    @OneToOne(fetch = FetchType.EAGER)
//    //@JsonIgnoreProperties("account")
//    //@JsonBackReference(value = "clientaccounts-client")
//    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "client")
//    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAccounts that = (ClientAccounts) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
