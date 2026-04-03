package com.hotel.HotelService.Controller;

import com.hotel.HotelService.DTOs.HotelRequest;
import com.hotel.HotelService.Entities.Hotel;
import com.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelRequest hotelRequest){

        Hotel savedHotel = hotelService.create(hotelRequest);

        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable Integer hotelId){

        Hotel hotel = hotelService.get(hotelId);

        return new ResponseEntity<>(hotel, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {

        List<Hotel> allHotels = hotelService.getAllHotels();

        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }
}
