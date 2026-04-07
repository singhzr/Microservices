package com.user.service.UserService.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rating {

    String ratingId;
    Integer userId;
    Integer hotelId;
    String rating;
    String feedback;
    Hotel hotel;
}
