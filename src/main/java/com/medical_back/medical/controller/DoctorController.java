package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.DoctorDto;
import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.mapper.DoctorMapper;
import com.medical_back.medical.service.DoctorDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/medical/doctor")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DoctorController {

    private final DoctorDbService doctorDbService;
    private final DoctorMapper doctorMapper;

    @GetMapping(value = "{doctorId}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable long doctorId) throws ObjectsInClassNotFoundException {
        return ResponseEntity.ok(doctorMapper.mapToDoctorDto(doctorDbService.getDoctor(doctorId)));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<Doctor> doctors = doctorDbService.allDoctors();
        return ResponseEntity.ok(doctorMapper.mapToDoctorDtoList(doctors));
    }

    @DeleteMapping(value = "{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) {
        doctorDbService.deleteDoctor(doctorId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto)  {
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);
        Doctor savedDoctor = doctorDbService.saveDoctor(doctor);
        return ResponseEntity.ok(doctorMapper.mapToDoctorDto(savedDoctor));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createDoctor(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);
        doctorDbService.saveDoctor(doctor);
        return ResponseEntity.ok().build();
    }


}
