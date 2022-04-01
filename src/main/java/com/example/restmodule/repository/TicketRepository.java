package com.example.restmodule.repository;

import com.example.restmodule.entity.Event;
import com.example.restmodule.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
