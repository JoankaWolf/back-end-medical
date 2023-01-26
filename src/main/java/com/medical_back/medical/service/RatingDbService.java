package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Rating;
import com.medical_back.medical.exception.ObjectsInClassNotFoundException;
import com.medical_back.medical.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingDbService {

    private final RatingRepository ratingRepository;

    public Rating getRating (final Long ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(ObjectsInClassNotFoundException::new);
    }

    public void deleteRating(final Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public Rating saveRating(final Rating rating) {
        return  ratingRepository.save(rating);
    }

    public List<Rating> allRatingList() {
        return ratingRepository.findAll();
    }
}
