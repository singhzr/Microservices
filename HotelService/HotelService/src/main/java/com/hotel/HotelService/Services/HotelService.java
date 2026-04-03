package com.hotel.HotelService.Services;

import com.hotel.HotelService.Entities.Hotel;
import com.hotel.HotelService.DTOs.HotelRequest;

import java.util.List;

public interface HotelService {

    Hotel create(HotelRequest hotelRequest);

    List<Hotel> getAllHotels();

    Hotel get(Integer id);
}
