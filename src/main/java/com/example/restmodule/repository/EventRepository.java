package com.example.restmodule.repository;

import com.example.restmodule.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByTitle(String title);
}
