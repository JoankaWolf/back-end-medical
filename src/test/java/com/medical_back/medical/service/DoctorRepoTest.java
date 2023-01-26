package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorRepoTest {
    @Autowired
    private DoctorRepository doctorRepository;
    private Doctor doctor;



    @Test
    void testSaveDoctor() {
        //Given
        doctor = Doctor.builder().firstName("Jan")
                .lastName("Dan")
                .specialization("interna")
                .build();

        //When
        doctorRepository.save(doctor);
        long id = doctor.getId();
        List<Doctor> doctors  = doctorRepository.findAll();

        //Then
        assertEquals(1, doctors.size());

        //Cleanup
        doctorRepository.deleteById(id);

    }
}