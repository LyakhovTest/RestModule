package com.example.restmodule.service;

import com.example.restmodule.dto.CreateUserDto;
import com.example.restmodule.entity.User;
import com.example.restmodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User updateUser(CreateUserDto userDto, int id) {
       User user = User.builder()
                .id(id)
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
