package com.medical_back.medical.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@AllArgsConstructor
@Getter
public class DoctorDtoAll {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private List<RatingDto> ratings;
    private List<VisitDto> listOfVisits;
}
