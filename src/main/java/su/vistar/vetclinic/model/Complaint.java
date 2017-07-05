package su.vistar.vetclinic.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Entity
@Table(name = "complaint", schema = "vetclinic")
public class Complaint {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complaint complaint = (Complaint) o;

        if (id != null ? !id.equals(complaint.id) : complaint.id != null) return false;
        if (date != null ? !date.equals(complaint.date) : complaint.date != null) return false;
        if (description != null ? !description.equals(complaint.description) : complaint.description != null)
            return false;
        if (animal != null ? !animal.equals(complaint.animal) : complaint.animal != null) return false;
        if (employee != null ? !employee.equals(complaint.employee) : complaint.employee != null) return false;
        return status != null ? status.equals(complaint.status) : complaint.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (animal != null ? animal.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
