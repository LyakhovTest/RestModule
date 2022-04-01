package com.example.restmodule.service;

import com.example.restmodule.dto.CreateTicketDto;
import com.example.restmodule.entity.Ticket;
import com.example.restmodule.entity.User;
import com.example.restmodule.error.NotEnoughMoney;
import com.example.restmodule.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final UserService userService;

    @Override
    @Transactional
    public Ticket createTicket(CreateTicketDto ticketDto) throws Exception {
        Ticket ticket = Ticket.builder()
                .eventId(ticketDto.getEventId())
                .userId(ticketDto.getUserId())
                .category(ticketDto.getCategory())
                .place(ticketDto.getPlace())
                .cost(ticketDto.getCost())
                .build();
        User user = userService.getUser(ticket.getUserId());
        if(user.getAccount()>=ticket.getCost()){
            user.setAccount(user.getAccount()-ticket.getCost());
            userService.spendMoney(user.getId(), ticket.getCost());
            return ticketRepository.save(ticket);
        }else throw new NotEnoughMoney();
        //return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public Ticket updateTicket(CreateTicketDto ticketDto, int id) {
        Ticket event = Ticket.builder()
                .id(id)
                .eventId(ticketDto.getEventId())
                .userId(ticketDto.getUserId())
                .category(ticketDto.getCategory())
                .place(ticketDto.getPlace())
                .cost(ticketDto.getCost())
                .build();
        return ticketRepository.save(event);
    }

    @Override
    @Transactional
    public Ticket getTicket(int id) {
        Ticket event = null;
        Optional<Ticket> ev = ticketRepository.findById(id);
        if(ev.isPresent()){
            event = ev.get();
        }
        return event;
    }

    @Override
    @Transactional
    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
