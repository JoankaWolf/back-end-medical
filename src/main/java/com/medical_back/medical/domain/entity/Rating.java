package com.medical_back.medical.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private double value;

    @ManyToOne
    @JoinColumn(name = "visit_doctor_id", referencedColumnName = "Id")
    @JsonBackReference
    private Doctor doctor;

}
