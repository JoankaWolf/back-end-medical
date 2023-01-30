package com.medical_back.medical.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;

}
