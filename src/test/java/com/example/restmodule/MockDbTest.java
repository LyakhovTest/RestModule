package com.example.restmodule;

import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.entity.Event;
import com.example.restmodule.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MockDbTest {
    @MockBean
    EventRepository eventRepository;


    @Test
    public void showEventTest() {
        Event event = eventRepository.getById(1);
        System.out.println(event);
//        //Given
//        Event event = new Event(1,"wad",
//                "asfasd"
//                , "dsaf",
//                "sadf",
//                Instant.now());
//        eventRepository.save(event);
//        //When
//        eventRepository
//        Event eve = eventController.showEvent(1);
//        //Then
//        assertEquals(event.getId(), eve.getId());
    }
    @Test
    public void test(){
        Event event = eventRepository.save(new Event(3,"wad",
                "asfasd"
                , "dsaf",
                "sadf",
                Instant.now()));
        System.out.println(event);
    }
}
