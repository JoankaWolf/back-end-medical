package com.medical_back.medical.domain.dto;

import com.medical_back.medical.domain.entity.StatusVisit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class VisitDto {

    private long id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private double price;
    private String notes;
    private boolean isPaid;
    StatusVisit statusVisit;
    private Long doctorId;
    private Long patientId;

}
