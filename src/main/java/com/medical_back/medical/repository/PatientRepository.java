package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Override
    List<Patient> findAll();

    @Override
    Patient save(Patient patient);

    @Override
    void deleteById(Long id);
}
