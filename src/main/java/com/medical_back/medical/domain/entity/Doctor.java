package com.medical_back.medical.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Visit> visits;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Rating> ratings;




}
