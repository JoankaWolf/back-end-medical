package com.medical_back.medical.repository;

import com.medical_back.medical.domain.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RatingRepository extends CrudRepository<Rating, Long> {

    @Override
    Rating save(Rating rating);

    @Override
    void deleteById(Long ratingId);

    @Override
    List<Rating> findAll();
}
