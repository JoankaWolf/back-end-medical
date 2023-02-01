package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DoctorDbServiceTest {

    private Doctor doctor;

    @Autowired
    DoctorDbService dbService;


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
    void allDoctorsTest() {

        //Given&When
        dbService.saveDoctor(doctor);
        long id = doctor.getId();
        List<Doctor> doctors  = dbService.allDoctors();

        //Then
        assertEquals("John", doctors.get(doctors.size()-1).getFirstName());

        //Cleanup
        dbService.deleteDoctor(id);

    }
}