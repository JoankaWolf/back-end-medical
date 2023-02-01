package com.medical_back.medical.service;

import com.medical_back.medical.domain.entity.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RatingDbServiceTest {

    private Rating rating;
    private Rating ratingOne;

    @Autowired
    RatingDbService dbService;


    @BeforeEach
    void setUp(){

        rating = Rating.builder().id(null)
                .value(3)
                .doctor(null)
                .build();

        ratingOne = Rating.builder().id(null)
                .value(2)
                .doctor(null)
                .build();
    }

    @Test
    void allRatingList() {
        //Given&When
        dbService.saveRating(ratingOne);
        dbService.saveRating(rating);
        long id = rating.getId();
        long idOne = ratingOne.getId();
        List<Rating> result = dbService.allRatingList();

        //Then
        assertEquals(3, result.get(result.size()-1).getValue());

        //Cleanup
        dbService.deleteRating(id);
        dbService.deleteRating(idOne);

    }
}