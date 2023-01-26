package com.medical_back.medical.domain.dto;

import com.medical_back.medical.domain.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;

}
