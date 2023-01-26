package com.medical_back.medical.mapper;

import com.medical_back.medical.domain.dto.RatingDto;
import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.service.DoctorDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingMapper {

    private final DoctorDbService doctorDbService;


    public Rating mapToRating(final RatingDto ratingDto) {
        return  Rating.builder()
                .id(ratingDto.getId())
                .value(ratingDto.getValue())
                .doctor(doctorDbService.getDoctor(ratingDto.getDoctorId()))
                .build();
    }

    public RatingDto mapToRatingDto(final Rating rating) {
        return new RatingDto(
                rating.getId(),
                rating.getValue(),
                rating.getDoctor().getId()
        );
    }

    public List<RatingDto> mapToRatingDtoList(final List<Rating> ratingList) {
        return ratingList.stream()
                .map(this::mapToRatingDto)
                .collect(Collectors.toList());

    }

    public List<Rating> mapToRatingList(final List<RatingDto> ratingDtoList) {
        return ratingDtoList.stream()
                .map(this::mapToRating)
                .collect(Collectors.toList());
    }
}
