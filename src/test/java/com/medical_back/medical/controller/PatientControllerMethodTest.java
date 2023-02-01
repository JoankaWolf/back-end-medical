package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.PatientDto;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.mapper.PatientMapper;
import com.medical_back.medical.service.PatientDbService;
import com.medical_back.medical.service.VisitDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class PatientControllerMethodTest {

    @InjectMocks
    PatientController controller;
    @Mock
    PatientDbService service;
    @Mock
    private PatientMapper mapper;
    private PatientDto patientDto;
    private Patient patient;

    @Autowired
    VisitDbService visitDbService;


    @BeforeEach
    void setUp() {

        patient = Patient.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .peselNumber(123L)
                .visits(new ArrayList<>())
                .build();
        patientDto = new PatientDto(2L, "test", "testName", "test", 555L, new ArrayList<>());

    }

    @Test
    void getPatient() throws RuntimeException {
        //Given
        when(mapper.mapToPatientDto(patient)).thenReturn(patientDto);
        when(service.getPatient(patient.getId())).thenReturn(patient);

        //When
        ResponseEntity<PatientDto> result = controller.getPatient(patient.getId());

        //Then
        assertEquals("testName", result.getBody().getLastName());
    }


    @Test
    void getAllPatients() {
        //Given
        List<Patient> patients = List.of(patient);
        List<PatientDto> patientDtos = List.of(patientDto);

        when(mapper.mapToPatientDtoList(patients)).thenReturn(patientDtos);
        when(service.allPatients()).thenReturn(patients);

        //When
        ResponseEntity<List<PatientDto>> result = controller.getAllPatients();

        //Then
        assertThat(result.getBody()).isNotNull();
        assertEquals(result.getBody().get(0).getId(), 2L);
    }
}