package com.rating.RatingService.Services;

import com.rating.RatingService.DTOs.RatingRequest;
import com.rating.RatingService.Entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(RatingRequest ratingRequest);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(Integer userId);

    List<Rating> getRatingByHotelId(Integer hotelId);
}
