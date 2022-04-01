package com.example.restmodule.service;

import com.example.restmodule.dto.CreateUserDto;
import com.example.restmodule.entity.User;
import com.example.restmodule.error.NotEnoughMoney;
import com.example.restmodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(CreateUserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(CreateUserDto userDto, int id) {
       User user = User.builder()
                .id(id)
                .email(userDto.getEmail())
                .name(userDto.getName())
                .build();
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        User user = null;
        Optional<User> us = userRepository.findById(id);
        if(us.isPresent()){
            user = us.get();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User addMoney(int id, int sum) {
        User user = getUser(id);
        if(user!=null){
            user.setAccount(user.getAccount()+sum);
        }
        return user;
    }

    @Override
    @Transactional
    public void spendMoney(int id, int sum) {
        User user = getUser(id);
        if(user!=null){
            if(user.getAccount()>=sum) {
                user.setAccount(user.getAccount() - sum);
            } else throw new NotEnoughMoney();
            user.setAccount(user.getAccount()-sum);
        }
    }
}
