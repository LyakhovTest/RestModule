package com.example.restmodule.controller;

import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.entity.Event;
import com.example.restmodule.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event")
    public List<Event> showAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/event/{id}")
    public Event showEvent(@PathVariable("id") int id) {
        return eventService.getEvent(id);
    }

    @PostMapping("/event")
    public Event saveEvent(@RequestBody CreateEventDto eventDto){
        return  eventService.createEvent(eventDto);
    }

    @PutMapping("/event/{id}")
    public Event updateEvent(@RequestBody CreateEventDto eventDto, @PathVariable("id") int id){
        return eventService.updateEvent(eventDto, id);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable("id") int id){
        eventService.deleteEvent(id);
    }

    @GetMapping("/event/title/{title}")
    public List<Event> getAllEventsByTitle(@PathVariable("title") String title){
        return eventService.getAllEventsByTitle(title);
    }
}
