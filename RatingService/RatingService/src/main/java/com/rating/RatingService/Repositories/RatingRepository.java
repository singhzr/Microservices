package com.rating.RatingService.Repositories;

import com.rating.RatingService.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(Integer userId);
    List<Rating> findByHotelId(Integer hotelId);
}
