package com.example.restmodule.service;

import com.example.restmodule.dto.CreateTicketDto;
import com.example.restmodule.dto.CreateUserDto;
import com.example.restmodule.entity.Ticket;
import com.example.restmodule.entity.User;

import java.util.List;

public interface TicketService {
    Ticket createTicket(CreateTicketDto ticketDto) throws Exception;
    Ticket updateTicket(CreateTicketDto ticketDto, int id);
    Ticket getTicket(int id);
    void deleteTicket(int id);
    List<Ticket> getAllTickets();
}
