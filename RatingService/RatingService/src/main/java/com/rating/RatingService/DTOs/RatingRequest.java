package com.rating.RatingService.DTOs;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingRequest {
    Integer userId;
    Integer hotelId;
    String rating;
    String feedback;
}
