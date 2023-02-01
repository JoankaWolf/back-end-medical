package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.DoctorDto;
import com.medical_back.medical.domain.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DoctorMapperTest {

    private DoctorMapper mapper;
    private DoctorDto doctorDto;
    private Doctor doctor;
    @Autowired
    private VisitMapper visitMapper;
    @Autowired
    private RatingMapper ratingMapper;


    @BeforeEach
    void valueForTests() {

        mapper = new DoctorMapper(visitMapper, ratingMapper);
        doctor = Doctor.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .specialization("Spec")
                .ratings(new ArrayList<>())
                .visits(new ArrayList<>())
                .build();
        doctorDto = new DoctorDto(1L, "test", "testName", "test");

    }

    @Test
    void mapToDoctorTest() {
        //Given&When
        Doctor doctor1 = mapper.mapToDoctor(doctorDto);
        //Then
        assertEquals("test", doctor1.getFirstName());
        assertEquals("testName", doctor1.getLastName());

    }

    @Test
    void  mapToDoctorDtoTest() {
        //Given&When
        DoctorDto doctorDto1 = mapper.mapToDoctorDto(doctor);
        //Then
        assertEquals("John", doctorDto1.getFirstName());
        assertEquals("Last", doctorDto1.getLastName());


    }
    @Test
    void  mapToDoctorDtoListTest() {
        //Given
        List<Doctor> doctors = List.of(doctor);

        //When
        List<DoctorDto> resultList = mapper.mapToDoctorDtoList(doctors);

        //Given
        assertEquals(1, resultList.size());
        assertEquals("Last", resultList.get(0).getLastName());
    }

}
