package com.hotel.HotelService.DTOs;

import com.hotel.HotelService.Entities.Hotel;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequest {
    String name;
    String about;
    String location;

    @Transient
    List<Hotel> allHotels = new ArrayList<>();
}
