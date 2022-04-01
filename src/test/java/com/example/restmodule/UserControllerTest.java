package com.example.restmodule;

import com.example.restmodule.controller.UserController;
import com.example.restmodule.entity.User;
import com.example.restmodule.repository.UserRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest extends BaseItTest{
    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @Test
    public void showUserTest() {
        tr.executeWithoutResult(s -> {
            //Given
            User expectedUser = userRepository.save(User.builder()
                    .email("test")
                    .name("test")
                    .account(100)
                    .build());
            //When
            User actualUser = userController.showUser(expectedUser.getId());
            //Then
            assertEquals(expectedUser.getAccount(), actualUser.getAccount());
        });
    }

    @Test
    public void showClientUserTest() {
        //Given
        User expectedUser = new User(1,
                "test",
                "test",
                100);
        userRepository.save(expectedUser);
        //When
        User actualUser = RestAssured.given().when().get("/user/{id}", expectedUser.getId())
                .then().statusCode(200).extract().as(User.class);
        //Then
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    public void addMoneyToAccount() {
        //Given
        User expectedUser = new User(1,
                "test",
                "test",
                100);
        userRepository.save(expectedUser);
        //When
        User userWithHundred = RestAssured.given().when().put("/user/{id}/addMoney/{sum}", expectedUser.getId(), 100)
                .then().statusCode(200).extract().as(User.class);
        //Then
        assertEquals(200, userWithHundred.getAccount());
    }
}
