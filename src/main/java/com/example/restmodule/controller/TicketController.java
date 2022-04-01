package com.example.restmodule.controller;

import com.example.restmodule.dto.CreateTicketDto;
import com.example.restmodule.entity.Ticket;
import com.example.restmodule.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> showAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/{id}")
    public Ticket showTicket(@PathVariable("id") int id) {
        return ticketService.getTicket(id);
    }

//    @PostMapping("/ticket")
//    public Ticket saveTicket(@RequestBody CreateTicketDto ticketDto) throws Exception {
//        return  ticketService.createTicket(ticketDto);
//    }

    @PutMapping("/ticket/{id}")
    public Ticket updateTicket(@RequestBody CreateTicketDto ticketDto, @PathVariable("id") int id){
        return ticketService.updateTicket(ticketDto, id);
    }

    @DeleteMapping("/ticket/{id}")
    public void deleteTicket(@PathVariable("id") int id){
        ticketService.deleteTicket(id);
    }

    @PostMapping("/ticket")
    public Ticket buyTicket(@RequestBody CreateTicketDto ticketDto) throws Exception {
        return  ticketService.createTicket(ticketDto);
    }
}
