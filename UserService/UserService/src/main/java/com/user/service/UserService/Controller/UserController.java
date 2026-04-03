package com.user.service.UserService.Controller;

import com.user.service.UserService.DTOs.UserRequest;
import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){

        User savedUser = userService.saveUser(userRequest);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){

        User user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> allUsers = userService.allUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
