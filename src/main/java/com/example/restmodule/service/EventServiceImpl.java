package com.example.restmodule.service;

import com.example.restmodule.dto.CreateEventDto;
import com.example.restmodule.entity.Event;
import com.example.restmodule.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    @Override
    @Transactional
    public Event createEvent(CreateEventDto eventDto) {
        Event event = Event.builder()
                .eventType(eventDto.getEventType())
                .dateTime(eventDto.getDateTime())
                .place(eventDto.getPlace())
                .title(eventDto.getTitle())
                .speaker(eventDto.getSpeaker())
                .build();
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public Event updateEvent(CreateEventDto eventDto, int id) {
        Event event = Event.builder()
                .id(id)
                .eventType(eventDto.getEventType())
                .dateTime(eventDto.getDateTime())
                .place(eventDto.getPlace())
                .title(eventDto.getTitle())
                .speaker(eventDto.getSpeaker())
                .build();
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public Event getEvent(int id) {
        Event event = null;
        Optional<Event> ev = eventRepository.findById(id);
        if(ev.isPresent()){
            event = ev.get();
        }
        return event;
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepository.findAllByTitle(title);
    }
}
