package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Doctor;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.domain.entity.Visit;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.repository.VisitRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitDbService {
    private final VisitRepository visitRepository;


    public Visit getVisit(final Long visitId) throws ObjectsInClassNotFoundException {
        return visitRepository.findById(visitId).orElseThrow(ObjectsInClassNotFoundException::new);
    }

    public List<Visit> allVisits() {
        return visitRepository.findAll();
    }

    public Visit saveVisit(final Visit visit){
        return visitRepository.save(visit);
    }

    public void deleteVisit(final Long visitId) {
        visitRepository.deleteById(visitId);
    }

    public List<Visit> allVisitsForPatient(final Long patientId) {
        return visitRepository.findVisitsByPatient_Id(patientId);
    }

    public List<Visit> allVisitsForDoctor(final Long doctorId) {
        return visitRepository.findVisitsByDoctor_Id(doctorId);
    }

}
