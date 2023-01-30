package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DoctorRepoTest {

    @Autowired
    private DoctorRepository doctorRepository;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = Doctor.builder().id(null)
                .firstName("John")
                .lastName("Last")
                .specialization("Spec")
                .ratings(new ArrayList<>())
                .visits(new ArrayList<>())
                .build();
    }

    @Test
    void testSaveDoctor() {
        //Given&When
        doctorRepository.save(doctor);
        long id = doctor.getId();
        List<Doctor> doctors  = doctorRepository.findAll();

        //Then
        assertEquals(1, doctors.size());
        assertEquals("John", doctors.get(0).getFirstName());

        //Cleanup
        doctorRepository.deleteById(id);
    }

    @Test
    void testDeleteDoctor() {

       //Given&When
        doctorRepository.save(doctor);
        long idD = doctor.getId();
        List<Doctor> doctorsList  = doctorRepository.findAll();
        assertEquals(1, doctorsList.size());

        //When
        doctorRepository.deleteById(idD);
        List<Doctor> resultList = doctorRepository.findAll();

        //Then
        assertEquals(0, resultList.size());
    }

}