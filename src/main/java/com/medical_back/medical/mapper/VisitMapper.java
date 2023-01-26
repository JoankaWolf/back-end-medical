package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.VisitDto;
import com.medical_back.medical.domain.entity.Visit;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.service.DoctorDbService;
import com.medical_back.medical.service.PatientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitMapper {

    private final DoctorDbService doctorDbService;
    private final PatientDbService patientDbService;


    public VisitDto mapToVisitDto(final Visit visit) {
        return new VisitDto(visit.getId(), visit.getAppointmentDate(),
                visit.getAppointmentTime(), visit.getPrice(), visit.getNotes(), visit.isPaid(), visit.getStatusVisit(),
                visit.getDoctor().getId(), visit.getPatient().getId());
    }

    public Visit mapToVisit(final VisitDto visitDto) throws ObjectsInClassNotFoundException{

            return Visit.builder()
                    .id(visitDto.getId())
                    .appointmentDate(visitDto.getAppointmentDate())
                    .appointmentTime(visitDto.getAppointmentTime())
                    .price(visitDto.getPrice())
                    .notes(visitDto.getNotes())
                    .isPaid(visitDto.isPaid())
                    .statusVisit(visitDto.getStatusVisit())
                    .doctor(doctorDbService.getDoctor(visitDto.getDoctorId()))
                    .patient(patientDbService.getPatient(visitDto.getPatientId()))
                    .build();

    }

    public List<VisitDto> mapToVisitDtoList (final List<Visit> visitList){
        return visitList.stream().map(this::mapToVisitDto)
                .collect(Collectors.toList());
    }

    public List<Visit> mapToVisitList (final List<VisitDto> visitDtoList) {
            return visitDtoList.stream().map(this::mapToVisit)
                    .collect(Collectors.toList());
    }
}
