package com.hotel.HotelService.Repositories;

import com.hotel.HotelService.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
