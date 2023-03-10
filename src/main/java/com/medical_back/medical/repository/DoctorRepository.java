package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    List<Doctor> findAll();

    @Override
    Doctor save(Doctor doctor);

    @Override
    void deleteById(Long id);

}
