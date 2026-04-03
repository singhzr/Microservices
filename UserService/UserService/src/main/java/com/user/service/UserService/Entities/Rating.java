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
    String userId;
    String hotelId;
    String rating;
    String feedback;
}
