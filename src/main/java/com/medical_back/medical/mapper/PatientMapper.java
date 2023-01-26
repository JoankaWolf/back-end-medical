package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.PatientDto;
import com.medical_back.medical.domain.entity.Patient;
import com.medical_back.medical.repository.PatientRepository;
import com.medical_back.medical.service.PatientDbService;
import com.medical_back.medical.service.VisitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientMapper {


    private final VisitDbService visitDbService;
    private final VisitMapper visitMapper;

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList){
        return patientList.stream()
                .map(this::mapToPatientDto)
                .collect(Collectors.toList());

    }

    public Patient mapToPatient(final PatientDto patientDto) {
        return  Patient.builder()
                .id(patientDto.getId())
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .email(patientDto.getEmail())
                .peselNumber(patientDto.getPeselNumber())
                .visits(visitDbService.allVisitsForPatient(patientDto.getId()))
                .build();
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(patient.getId(), patient.getFirstName(),
                patient.getLastName(), patient.getEmail(),
                patient.getPeselNumber(), visitMapper.mapToVisitDtoList(patient.getVisits()));
    }

}
