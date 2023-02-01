package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorDbService {
    private final DoctorRepository doctorRepository;

    public Doctor getDoctor(final Long doctorId) throws ObjectsInClassNotFoundException {
        return doctorRepository.findById(doctorId).orElseThrow(ObjectsInClassNotFoundException::new);
    }

    public List<Doctor> allDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(final Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(final Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }

//    public List<Long> allDoctorsId(){
//        return doctorRepository.findAll().stream().map(Doctor::getId).collect(Collectors.toList());
//    }
}
