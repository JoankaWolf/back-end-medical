package com.medical_back.medical.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long peselNumber;
    private List<VisitDto> visits;
}
