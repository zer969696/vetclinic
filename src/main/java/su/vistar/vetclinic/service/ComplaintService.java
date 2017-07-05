package su.vistar.vetclinic.service;

import su.vistar.vetclinic.model.Complaint;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */
public interface ComplaintService {

    Complaint findById(int id);

    List<Complaint> findAllByAnimalId(int animalId);

    List<Complaint> findThreeLastComplaintByEmployeeId(int employeeId);

    Complaint findLastComplaintByAnimalId(int animalId);

    Integer getComplaintsCountByAnimalId(int animalId);
}
