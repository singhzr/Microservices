package com.rating.RatingService.Controller;

import com.rating.RatingService.DTOs.RatingRequest;
import com.rating.RatingService.Entities.Rating;
import com.rating.RatingService.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest ratingRequest){

        Rating rating = ratingService.create(ratingRequest);

        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){

        List<Rating> ratingList = ratingService.getRatings();

        return new ResponseEntity<>(ratingList, HttpStatus.FOUND);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

        List<Rating> ratingList = ratingService.getRatingByUserId(userId);

        return new ResponseEntity<>(ratingList, HttpStatus.FOUND);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){

        List<Rating> ratingList = ratingService.getRatingByHotelId(hotelId);

        return new ResponseEntity<>(ratingList, HttpStatus.FOUND);
    }
}
