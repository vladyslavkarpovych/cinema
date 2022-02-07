package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Ticket;
import com.gmail.karpovych.springdemoboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket findById(Integer ticketId) {
        return ticketRepository.getOne(ticketId);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteById(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
