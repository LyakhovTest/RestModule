package com.example.restmodule.controller;

import com.example.restmodule.dto.CreateUserDto;
import com.example.restmodule.entity.User;
import com.example.restmodule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;

    @GetMapping("/user")
    public List<User> showAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User showUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody CreateUserDto userDto){
        return  userService.createUser(userDto);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody CreateUserDto userDto, @PathVariable("id") int id){
        return userService.updateUser(userDto, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}/addMoney/{sum}")
    public User addHundredToAccount(@PathVariable("id") int id, @PathVariable("sum") int sum){
        return userService.addMoney(id,sum);
    }


}
