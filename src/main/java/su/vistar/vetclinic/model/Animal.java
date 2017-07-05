package su.vistar.vetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
@Entity
@Table(name = "animal", schema = "vetclinic")
public class Animal {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "photo_id", nullable = false)
    private String photoId;

    @Basic
    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id", insertable = false, updatable = false)
////    @JsonIgnoreProperties("animal")
//    //@JsonBackReference(value = "client-animal")
//    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "client")
//    private Client client;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal")
//    //@JsonIgnoreProperties("animal")
//    //@JsonBackReference(value = "complaint-animal")
//    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="complaints")
//    private List<Complaint> complaints;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != null ? !id.equals(animal.id) : animal.id != null) return false;
        if (photoId != null ? !photoId.equals(animal.photoId) : animal.photoId != null) return false;
        if (clientId != null ? !clientId.equals(animal.clientId) : animal.clientId != null) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (description != null ? !description.equals(animal.description) : animal.description != null) return false;
        return date != null ? date.equals(animal.date) : animal.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
