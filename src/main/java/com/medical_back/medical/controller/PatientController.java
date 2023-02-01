package com.medical_back.medical.controller;


import com.medical_back.medical.domain.dto.PatientDto;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.mapper.PatientMapper;
import com.medical_back.medical.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/medical/patient")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

    private final PatientDbService patientDbService;
    private final PatientMapper patientMapper;

    @GetMapping(value = "{patientId}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable long patientId) throws ObjectsInClassNotFoundException {
        return ResponseEntity.ok(patientMapper.mapToPatientDto(patientDbService.getPatient(patientId)));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<Patient> patients = patientDbService.allPatients();
        return ResponseEntity.ok(patientMapper.mapToPatientDtoList(patients));
    }

    @DeleteMapping(value = "{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        patientDbService.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) throws  ObjectsInClassNotFoundException{
        Patient patient = patientMapper.mapToPatient(patientDto);
        Patient patientSaved = patientDbService.savePatient(patient);
        return ResponseEntity.ok(patientMapper.mapToPatientDto(patientSaved));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPatient(@RequestBody PatientDto patientDto) throws ObjectsInClassNotFoundException{
        Patient patient = patientMapper.mapToPatient(patientDto);
        patientDbService.savePatient(patient);
        return ResponseEntity.ok().build();
    }

}
