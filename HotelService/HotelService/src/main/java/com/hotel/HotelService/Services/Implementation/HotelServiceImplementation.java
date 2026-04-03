package com.hotel.HotelService.Services.Implementation;

import com.hotel.HotelService.DTOs.HotelRequest;
import com.hotel.HotelService.Entities.Hotel;
import com.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.hotel.HotelService.Repositories.HotelRepository;
import com.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImplementation implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(HotelRequest hotelRequest) {
        Hotel hotel = Hotel.builder()
                .name(hotelRequest.getName())
                .about(hotelRequest.getAbout())
                .location(hotelRequest.getLocation())
                .build();

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(Integer id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);

        if(optionalHotel.isEmpty()){
            throw new ResourceNotFoundException("Hotel with hotel ID " +id +" not found");
        }
        return optionalHotel.get();
    }
}
