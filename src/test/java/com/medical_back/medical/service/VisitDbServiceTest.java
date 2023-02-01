package com.medical_back.medical.service;

import com.medical_back.medical.domain.StatusVisit;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.domain.entity.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VisitDbServiceTest {

    private Visit visit;

    @Autowired
    VisitDbService dbService;


    @BeforeEach
    void setUp() {
        visit = Visit.builder().id(null)
                .statusVisit(StatusVisit.FREE)
                .appointmentDate(LocalDate.of(2023,01,12))
                .appointmentTime(LocalTime.of(12, 20))
                .price(120.0)
                .notes("test")
                .isPaid(true)
                .patient(null)
                .doctor(null)
                .build();
    }

    @Test
    void allVisitsTest() {
        //Given&When
        dbService.saveVisit(visit);
        long id = visit.getId();
        List<Visit> result  = dbService.allVisits();

        //Then
        assertEquals(120.0, result.get(result.size()-1).getPrice());

        //Cleanup
        dbService.deleteVisit(id);

    }
}