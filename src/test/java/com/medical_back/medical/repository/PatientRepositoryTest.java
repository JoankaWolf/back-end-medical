package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    private Patient patient;

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
    void testSave() {
        //Given&When
        patientRepository.save(patient);
        long id = patient.getId();
        List<Patient> patients  = patientRepository.findAll();

        //Then
        assertEquals(1, patients.size());
        assertEquals("John", patients.get(0).getFirstName());

        //Cleanup
        patientRepository.deleteById(id);
    }


    @Test
    void testDeleteById() {
        //Given&When
        patientRepository.save(patient);
        long idD = patient.getId();
        List<Patient> patientList  = patientRepository.findAll();
        assertEquals(1, patientList.size());

        //When
        patientRepository.deleteById(idD);
        List<Patient> resultList = patientRepository.findAll();

        //Then
        assertEquals(0, resultList.size());
    }
}