package com.medical_back.medical.controller;

import com.medical_back.medical.domain.dto.RatingDto;
import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.mapper.RatingMapper;
import com.medical_back.medical.service.RatingDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/medical/rating")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RatingController {

    private final RatingMapper ratingMapper;
    private final RatingDbService ratingDbService;


    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        List<Rating> ratings = ratingDbService.allRatingList();
        return ResponseEntity.ok(ratingMapper.mapToRatingDtoList(ratings));
    }


    @GetMapping(value = "{ratingId}")
    public ResponseEntity<RatingDto> getRating(@PathVariable long ratingId) throws ObjectsInClassNotFoundException {
        return ResponseEntity.ok(ratingMapper.mapToRatingDto(ratingDbService.getRating(ratingId)));
    }

    @DeleteMapping(value = "{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingDbService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }



    @PutMapping
    public ResponseEntity<RatingDto> updateRating(@RequestBody RatingDto ratingDto) {
        Rating saveRating = ratingMapper.mapToRating(ratingDto);
        Rating rating = ratingDbService.saveRating(saveRating);
        return ResponseEntity.ok(ratingMapper.mapToRatingDto(rating));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRating(@RequestBody RatingDto ratingDto){
        Rating rating = ratingMapper.mapToRating(ratingDto);
        ratingDbService.saveRating(rating);
        return ResponseEntity.ok().build();
    }

}
