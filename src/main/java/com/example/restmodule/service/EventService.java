package com.example.restmodule.service;

import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(CreateEventDto eventDto);
    Event updateEvent(CreateEventDto eventDto, int id);
    Event getEvent(int id);
    void deleteEvent(int id);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}
