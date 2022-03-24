package com.example.restmodule;
import com.example.restmodule.controller.EventController;
import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.entity.Event;
import com.example.restmodule.repository.EventRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EventControllerTests extends BaseItTest{
    @Autowired
    EventController eventController;

    @Autowired
    EventRepository eventRepository;

    @Test
    public void showEventTest() {
        //Given
        Event expectedEvent = new Event(1, "wad",
                "asfasd"
                , "dsaf",
                "sadf",
                Instant.now());
        eventRepository.save(expectedEvent);
        //When
        Event actualEvent = RestAssured.given().when().get("/event/{id}", expectedEvent.getId())
                .then().statusCode(200).extract().as(Event.class);
        //Then
        assertEquals(expectedEvent, actualEvent);

//        List<Event> events = eventController.showAllEvents();
//        Event newEvent = events.stream().filter(ev->ev.getId()==1).findAny().orElse(null);
//        assertNotNull(newEvent);
    }

    @Test
    public void showAllEventsTest() {
        //Given
        Event event = new Event(1, "wad",
                "asfasd"
                , "dsaf",
                "sadf",
                Instant.now());
        eventRepository.save(event);
        Event event1 = new Event(2, "wad",
                "asfasd"
                , "dsaf",
                "sadf",
                Instant.now());
        eventRepository.save(event);
        eventRepository.save(event1);
        //When
        List<Event> events = eventController.showAllEvents();
        //Then
        assertEquals(2, events.size());
    }

    @Test
    public void saveEventTest() {
        //When
        Event event = eventController.saveEvent(new CreateEventDto("wad",
                "asfasd"
                , "dsaf",
                "sadf",
                Instant.now()));
        //Then
        assertEquals(event.getId(), eventRepository.findById(event.getId()).get().getId());
    }

    @Test
    public void showAllEventsByTitleTest() {
        //Give
        Event event1 = new Event(null,
                "wad",
                "asfasd",
                "dsaf",
                "sadf",
                Instant.now());
        eventRepository.save(event1);

        Event event2 = new Event(null,
                "test",
                "test",
                "test",
                "test",
                Instant.now());
        eventRepository.save(event2);

        Event event3 = new Event(null,
                "wad",
                "test",
                "test",
                "test",
                Instant.now());
        eventRepository.save(event3);
        //When
        List<Event> events = eventController.getAllEventsByTitle(event1.getTitle());
        //Then
        assertEquals(2, events.size());
        assertEquals(events.get(0).getTitle(), events.get(1).getTitle());
        assertEquals("wad", events.get(0).getTitle());
    }
}
