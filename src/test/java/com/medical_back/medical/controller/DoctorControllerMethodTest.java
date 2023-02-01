package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.DoctorDto;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.mapper.DoctorMapper;
import com.medical_back.medical.service.DoctorDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DoctorControllerMethodTest {

    @Mock
    private DoctorMapper mapper;
    private Doctor doctor;
    private DoctorDto doctorDto;
    @InjectMocks
    private DoctorController controller;

    @Mock
    DoctorDbService service;


    @BeforeEach
    void setUp() {

        doctor = Doctor.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .specialization("Spec")
                .ratings(new ArrayList<>())
                .visits(new ArrayList<>())
                .build();


        doctorDto = new DoctorDto(2L, "test", "test", "spec");
    }


    @Test
    void getDoctorTest() throws RuntimeException {
        //Given
        when(mapper.mapToDoctorDto(doctor)).thenReturn(doctorDto);
        when(service.getDoctor(doctor.getId())).thenReturn(doctor);

        //When
        ResponseEntity<DoctorDto> result = controller.getDoctor(doctor.getId());

        //Then
        assertEquals("test", result.getBody().getLastName());
    }


    @Test
    void getAllDoctorsTest() {

        //Given
        List<Doctor> doctors = List.of(doctor);
        List<DoctorDto> doctorDtos = List.of(doctorDto);

        when(mapper.mapToDoctorDtoList(doctors)).thenReturn(doctorDtos);
        when(service.allDoctors()).thenReturn(doctors);

        //When
        ResponseEntity<List<DoctorDto>> result = controller.getAllDoctors();

        //Then
        assertThat(result.getBody()).isNotNull();
        assertEquals(result.getBody().get(0).getId(), 2L);
    }

}

