package com.medical_back.medical.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RatingDto {
    private Long id;
    private double value;
    private Long doctorId;
}
