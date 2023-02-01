package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.RatingDto;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.service.DoctorDbService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class RatingMapperTest {

    private RatingMapper mapper;
    private Rating rating;
    private RatingDto ratingDto;
    @Mock
    DoctorDbService doctorDbService;


    @BeforeEach
    void setUp() {
        mapper = new RatingMapper(doctorDbService);
        Doctor doctor = Doctor.builder().id(1L)
                .firstName("John")
                .lastName("Last")
                .specialization("Spec")
                .ratings(new ArrayList<>())
                .visits(new ArrayList<>())
                .build();

        when(doctorDbService.getDoctor(any(Long.class))).thenReturn(doctor);

        rating = Rating.builder()
                .id(1L)
                .value(2.0)
                .doctor(doctorDbService.getDoctor(doctor.getId()))
                .build();

        ratingDto = new RatingDto(3L, 3.0, 5L);

    }

    @Test
    void mapToRating() {

        //Given&When
        Rating result = mapper.mapToRating(ratingDto);

        //Then
        assertEquals(3.0, result.getValue());
        assertEquals(3L, result.getId());

    }

    @Test
    void mapToRatingDto() {

        //Given&When
        RatingDto result = mapper.mapToRatingDto(rating);

        //Then
        assertEquals(2.0, result.getValue());
        assertEquals(1L, result.getId());


    }

    @Test
    void mapToRatingDtoList() {

        //Given
        List<Rating> ratingList = List.of(rating);

        //When
        List<RatingDto> resultList = mapper.mapToRatingDtoList(ratingList);

        //Then
        assertEquals(1, resultList.size());
        assertEquals(2.0, resultList.get(0).getValue());
    }

    @Test
    void mapToRatingList() {

        //Given
        List<RatingDto> ratingDtoList = List.of(ratingDto);

        //When
        List<Rating> resultList = mapper.mapToRatingList(ratingDtoList);

        //Then
        assertEquals(1, resultList.size());
        assertEquals(3.0, resultList.get(0).getValue());
    }
}