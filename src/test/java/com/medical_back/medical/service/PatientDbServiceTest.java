package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class PatientDbServiceTest {

    private Patient patient;

    @Autowired
    PatientDbService dbService;


    @BeforeEach
    void setUp() {

        patient = Patient.builder().id(null)
                .firstName("John")
                .lastName("Last")
                .peselNumber(123L)
                .visits(new ArrayList<>())
                .build();
    }

    @Test
    void allPatientsTest() {

        //Given&When
        dbService.savePatient(patient);
        long id = patient.getId();
        List<Patient> patients  = dbService.allPatients();

        //Then
        assertEquals(123L, patients.get(patients.size()-1).getPeselNumber());

        //Cleanup
        dbService.deletePatient(id);

    }
}