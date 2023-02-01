package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.PatientDto;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.service.VisitDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class PatientMapperTest {

    private PatientMapper mapper;
    private PatientDto patientDto;
    private Patient patient;
    @Autowired
    private VisitMapper visitMapper;

    @Autowired
    VisitDbService visitDbService;

    @BeforeEach
    void setUp() {
        mapper = new PatientMapper(visitDbService, visitMapper);
        patient = Patient.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .peselNumber(123L)
                .visits(new ArrayList<>())
                .build();
        patientDto = new PatientDto(1L, "test", "testName", "test", 555L, new ArrayList<>());

    }

    @Test
    void mapToPatientDtoList() {
        List<Patient> patients = List.of(patient);
        //When
        List<PatientDto> resultList = mapper.mapToPatientDtoList(patients);
        //Then
        assertEquals(1, resultList.size());
        assertEquals("Last", resultList.get(0).getLastName());
    }


    @Test
    void mapToPatient() {

        //Given&When
        Patient patient1 = mapper.mapToPatient(patientDto);

        //Then
        assertEquals("testName", patient1.getLastName());
        assertEquals("test", patient1.getFirstName());
    }

    @Test
    void mapToPatientDto() {

        //Given&When
        PatientDto patientDto1 = mapper.mapToPatientDto(patient);

        //Then
        assertEquals("Last", patientDto1.getLastName());
        assertEquals("John", patientDto1.getFirstName());
    }
}