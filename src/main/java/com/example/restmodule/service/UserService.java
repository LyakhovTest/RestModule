package com.example.restmodule.service;

import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.dto.CreateUserDto;
import com.example.restmodule.entity.Event;
import com.example.restmodule.entity.User;

import java.util.List;

public interface UserService {
    User createUser(CreateUserDto userDto);
    User updateUser(CreateUserDto userDto, int id);
    User getUser(int id);
    void deleteUser(int id);
    List<User> getAllUser();
}
