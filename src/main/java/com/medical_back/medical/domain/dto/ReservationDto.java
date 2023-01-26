package com.medical_back.medical.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ReservationDto {
    private long id;
    private LocalDate date;
}
