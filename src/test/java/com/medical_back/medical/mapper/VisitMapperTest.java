package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.VisitDto;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.domain.StatusVisit;
import com.medical_back.medical.domain.entity.Visit;
import com.medical_back.medical.service.DoctorDbService;
import com.medical_back.medical.service.PatientDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class VisitMapperTest {

    private VisitMapper mapper;
    private VisitDto visitDto;
    private Visit visit;


    @Mock
    private DoctorDbService doctorDbService;
    @Mock
    private PatientDbService patientDbService;


    @BeforeEach
    void setUp() {
        mapper = new VisitMapper(doctorDbService,patientDbService);
        Doctor doctor = Doctor.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .specialization("Spec")
                .ratings(new ArrayList<>())
                .visits(new ArrayList<>())
                .build();

        Patient patient = Patient.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .peselNumber(123L)
                .visits(new ArrayList<>())
                .build();

        when(doctorDbService.getDoctor(any(Long.class))).thenReturn(doctor);
        when(patientDbService.getPatient(any(Long.class))).thenReturn(patient);

        visit = Visit.builder()
                .id(1L)
                .appointmentDate(LocalDate.of(2022, 12, 25))
                .appointmentTime(LocalTime.of(11, 20))
                .price(120.00)
                .notes("notes")
                .isPaid(false)
                .statusVisit(StatusVisit.DONE)
                .doctor(doctorDbService.getDoctor(doctor.getId()))
                .patient(patientDbService.getPatient(patient.getId()))
                .build();

        visitDto = new VisitDto(1L, LocalDate.of(2022, 12, 12),
        LocalTime.of(12, 30), 100.0, "nine", false, StatusVisit.DONE, 2L, 3L);


    }

    @Test
    void mapToVisitDto() {

        //Given&When
        Visit result = mapper.mapToVisit(visitDto);

        //Then
        assertEquals("nine", result.getNotes());
        assertEquals(100.0, result.getPrice());

    }

    @Test
    void mapToVisit() {

        //Given&When
        VisitDto result = mapper.mapToVisitDto(visit);

        //Then
        assertEquals("notes", result.getNotes());
        assertEquals(120.0, result.getPrice());

    }

    @Test
    void mapToVisitDtoList() {

        //Given
        List<Visit> visits = List.of(visit);

        //When
        List<VisitDto> resultList = mapper.mapToVisitDtoList(visits);

        //Then
        assertEquals(1, resultList.size());
        assertEquals(StatusVisit.DONE, resultList.get(0).getStatusVisit());
    }

    @Test
    void mapToVisitList() {

        //Given
        List<VisitDto> visits = List.of(visitDto);

        //When
        List<Visit> resultList = mapper.mapToVisitList(visits);

        //Then
        assertEquals(1, resultList.size());
        assertEquals(StatusVisit.DONE, resultList.get(0).getStatusVisit());
        assertEquals("nine", resultList.get(0).getNotes());

    }
}