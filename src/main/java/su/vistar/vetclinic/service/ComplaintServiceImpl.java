package su.vistar.vetclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.dao.ComplaintDao;
import su.vistar.vetclinic.model.Complaint;

import java.util.List;

/**
 * Created by Evgeniy Evzerov on 09.03.17.
 * VIstar
 */

@Service("complaintService")
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao dao;

    @Override
    public Complaint findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Complaint> findAllByAnimalId(int animalId) {
        return dao.findAllByAnimalId(animalId);
    }

    @Override
    public List<Complaint> findThreeLastComplaintByEmployeeId(int employeeId) {
        return dao.findThreeLastComplaintByEmployeeId(employeeId);
    }

    @Override
    public Complaint findLastComplaintByAnimalId(int animalId) {
        return dao.findLastComplaintByAnimalId(animalId);
    }

    @Override
    public Integer getComplaintsCountByAnimalId(int animalId) {
        return dao.getComplaintsCountByAnimalId(animalId);
    }
}
