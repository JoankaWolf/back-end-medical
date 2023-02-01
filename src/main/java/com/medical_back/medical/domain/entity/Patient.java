package com.medical_back.medical.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Builder
public class Patient {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private Long peselNumber;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<Visit> visits;

}
