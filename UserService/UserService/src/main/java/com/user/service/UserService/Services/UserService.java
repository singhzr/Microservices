package com.user.service.UserService.Services;

import com.user.service.UserService.DTOs.UserRequest;
import com.user.service.UserService.Entities.User;

import java.util.List;

public interface UserService{

    User saveUser(UserRequest userRequest);

    List<User> allUsers();

    User getUser(Integer userId);
}
