package com.rating.RatingService.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user_ratings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rating {

    @Id
    String ratingId;
    Integer userId;
    Integer hotelId;
    String rating;
    String feedback;
}

/*

@Document is an annotation from Spring Data MongoDB used to mark a class
as a MongoDB document (collection)

@Id When using MongoDB with Spring Boot, @Id is used to mark the primary key field
of a document, and it is automatically generated when database in MongoDB.

*/