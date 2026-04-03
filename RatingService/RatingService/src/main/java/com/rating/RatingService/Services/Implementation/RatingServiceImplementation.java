package com.rating.RatingService.Services.Implementation;

import com.rating.RatingService.DTOs.RatingRequest;
import com.rating.RatingService.Entities.Rating;
import com.rating.RatingService.Repositories.RatingRepository;
import com.rating.RatingService.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(RatingRequest ratingRequest) {

        Rating rating = Rating.builder()
                .userId(ratingRequest.getUserId())
                .rating(ratingRequest.getRating())
                .feedback(ratingRequest.getFeedback())
                .hotelId(ratingRequest.getHotelId())
                .build();
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
