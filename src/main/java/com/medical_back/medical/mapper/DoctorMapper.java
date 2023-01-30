package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.DoctorDto;
import com.medical_back.medical.domain.dto.DoctorDtoAll;
import com.medical_back.medical.domain.entity.Doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorMapper {

    private final VisitMapper visitMapper;

    private final RatingMapper ratingMapper;

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(this::mapToDoctorDto)
                .collect(Collectors.toList());

    }

    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return Doctor.builder()
                .id(doctorDto.getId())
                .firstName(doctorDto.getFirstName())
                .lastName(doctorDto.getLastName())
                .specialization(doctorDto.getSpecialization())
                .build();
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor){
        return new DoctorDto(doctor.getId(), doctor.getFirstName(),
                doctor.getLastName(), doctor.getSpecialization());
    }

    public Doctor mapToDoctorFromDoctorAll(final DoctorDtoAll doctorDtoAll) {
        return Doctor.builder()
                .id(doctorDtoAll.getId())
                .firstName(doctorDtoAll.getFirstName())
                .lastName(doctorDtoAll.getLastName())
                .specialization(doctorDtoAll.getSpecialization())
                .ratings(ratingMapper.mapToRatingList(doctorDtoAll.getRatings()))
                .visits(visitMapper.mapToVisitList(doctorDtoAll.getListOfVisits()))
                .build();
    }
}
