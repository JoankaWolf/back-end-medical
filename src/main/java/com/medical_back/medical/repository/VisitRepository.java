package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.domain.entity.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    List<Visit> findAll();

    @Override
   Visit save(Visit visit);

    @Override
    void deleteById(Long id);

    List<Visit> findVisitsByPatient_Id(Long patientId);

    List<Visit> findVisitsByDoctor_Id(Long doctorId);
}
