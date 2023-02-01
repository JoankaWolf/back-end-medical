package com.medical_back.medical.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.medical_back.medical.domain.StatusVisit;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column
    private LocalDate appointmentDate;

    @NotNull
 //   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    @Column
    private LocalTime appointmentTime;

    @Column
    private double price;

    @Column
    private String notes;

    @Column
    private boolean isPaid;

    @Column
    StatusVisit statusVisit;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Doctor doctor;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Patient patient;


}
