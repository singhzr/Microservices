package com.user.service.UserService.Services.Implementation;

import com.user.service.UserService.DTOs.UserRequest;
import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.user.service.UserService.Repositories.UserRepository;
import com.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

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
    public User getUser(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("User with ID "+userId +" not found!");
        }
        return userOptional.get();
    }
}
