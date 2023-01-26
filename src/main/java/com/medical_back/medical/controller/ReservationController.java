package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.VisitDto;
import com.medical_back.medical.domain.entity.Visit;
import com.medical_back.medical.mapper.VisitMapper;
import com.medical_back.medical.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/medical/reservation")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationController {

    private final VisitMapper visitMapper;
    private final VisitDbService visitDbService;


    @GetMapping(value =  "/doctor/{doctorId}")
    public ResponseEntity<List<VisitDto>> listOneDoctorVisits(@PathVariable Long doctorId) {
        List<Visit> allVisitsOnDoctor = visitDbService.allVisitsForDoctor(doctorId);
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(allVisitsOnDoctor));
    }

    @GetMapping(value = "/patient/{patientId}")
    public ResponseEntity<List<VisitDto>> listOnePatientVisits(@PathVariable Long patientId) {
        List<Visit> allVisitsOnPatient = visitDbService.allVisitsForPatient(patientId);
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(allVisitsOnPatient));
    }
}
