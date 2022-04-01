package com.example.restmodule;

import com.example.restmodule.controller.TicketController;
import com.example.restmodule.dto.CreateTicketDto;
import com.example.restmodule.entity.Category;
import com.example.restmodule.entity.Event;
import com.example.restmodule.entity.Ticket;
import com.example.restmodule.entity.User;
import com.example.restmodule.repository.EventRepository;
import com.example.restmodule.repository.TicketRepository;
import com.example.restmodule.repository.UserRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketControllerTest extends BaseItTest{
    @Autowired
    TicketController ticketController;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void showTicketTest() {
        //Given
        User expectedUser = new User(3,
                "test",
                "test",
                100);
        userRepository.save(expectedUser);

        Event expectedEvent = new Event(3,
                "testEvent",
                "testEvent",
                "testEvent",
                "testEvent",
                Instant.now(),
                null);
        eventRepository.save(expectedEvent);

        CreateTicketDto ticketDto = new CreateTicketDto(expectedEvent.getId()
                , expectedUser.getId(), Category.STANDARD, 13, 50);
        Ticket ticket = RestAssured.given().when().body(ticketDto).post("/ticket").then().statusCode(200).extract()
                .as(Ticket.class);
        User userWithTicket = userRepository.findById(ticket.getUserId()).get();

//        //When
//        User actualUser = RestAssured.given().when().get("/user/{id}", expectedUser.getId())
//                .then().statusCode(200).extract().as(User.class);
        //Then
        assertEquals(50, userWithTicket.getAccount());
    }

    @Test
    public void conflictBuyTicketWithoutMoneyTest() {
        //Given
        User expectedUser = new User(3,
                "test",
                "test",
                30);
        userRepository.save(expectedUser);

        Event expectedEvent = new Event(3,
                "testEvent",
                "testEvent",
                "testEvent",
                "testEvent",
                Instant.now(),
                null);
        eventRepository.save(expectedEvent);

        CreateTicketDto ticketDto = new CreateTicketDto(expectedEvent.getId()
                , expectedUser.getId(), Category.STANDARD, 13, 50);
        RestAssured.given().when().body(ticketDto).post("/ticket").then().statusCode(409);

        User userWithTicket = userRepository.findById(expectedUser.getId()).orElseThrow();



//        //When
//        User actualUser = RestAssured.given().when().get("/user/{id}", expectedUser.getId())
//                .then().statusCode(200).extract().as(User.class);
        //Then
        assertEquals(30, userWithTicket.getAccount());
    }
}
