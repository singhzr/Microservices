package com.user.service.UserService.Services.Implementation;

import com.user.service.UserService.DTOs.UserRequest;
import com.user.service.UserService.Entities.Hotel;
import com.user.service.UserService.Entities.Rating;
import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.user.service.UserService.ExternalServices.HotelService;
import com.user.service.UserService.Repositories.UserRepository;
import com.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .about(userRequest.getAbout())
                .email(userRequest.getEmail())
                .build();

        return userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        Rating[] allRatingsOfUser = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/"+userId, Rating[].class
        );

        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("User with ID "+userId +" not found!");
        }
        if(allRatingsOfUser == null){
            throw new ResourceNotFoundException("User with ID "+userId +" has not rated!");
        }
        for(Rating rating : allRatingsOfUser){
            Hotel hotel = hotelService.getHotel(rating.getHotelId()); //restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            rating.setHotel(hotel);
        }
        User user = userOptional.get();
        user.setRatingsList(Arrays.asList(allRatingsOfUser));

        return user;
    }
}
