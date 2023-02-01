package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.RatingDto;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.mapper.RatingMapper;
import com.medical_back.medical.service.DoctorDbService;
import com.medical_back.medical.service.RatingDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class RatingControllerTest {

    @Mock
    private RatingMapper mapper;
    @Mock
    private RatingDbService dbService;
    private Rating rating;
    private RatingDto ratingDto;
    private Doctor doctor;
    @InjectMocks
    private RatingController ratingController;

    @Mock
    DoctorDbService doctorDbService;


    @BeforeEach
    void setUp() {

        doctor = Doctor.builder().id(null)
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
    void getAllRatingsTest() {

        //Given
        List<Rating> ratings = List.of(rating);
        List<RatingDto> ratingDtos = List.of(ratingDto);

        when(mapper.mapToRatingDtoList(ratings)).thenReturn(ratingDtos);
        when(dbService.allRatingList()).thenReturn(ratings);

        //When
        ResponseEntity<List<RatingDto>> result = ratingController.getAllRatings();

        //Then
        assertThat(result.getBody()).isNotNull();
        assertEquals(result.getBody().get(0).getId(), 3L);
    }

    @Test
    void getRatingTest() throws RuntimeException {

        //Given
        when(mapper.mapToRatingDto(rating)).thenReturn(ratingDto);
        when(dbService.getRating(rating.getId())).thenReturn(rating);

        //When
        ResponseEntity<RatingDto> result = ratingController.getRating(rating.getId());

        //Then
        assertEquals(3.0, result.getBody().getValue());

    }

}