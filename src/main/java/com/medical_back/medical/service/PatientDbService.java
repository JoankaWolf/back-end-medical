package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientDbService {
    private final PatientRepository patientRepository;

    public Patient getPatient(final Long patientId) throws ObjectsInClassNotFoundException {
        return patientRepository.findById(patientId).orElseThrow(ObjectsInClassNotFoundException::new);
    }

    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }

    public Patient savePatient(final Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(final Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
