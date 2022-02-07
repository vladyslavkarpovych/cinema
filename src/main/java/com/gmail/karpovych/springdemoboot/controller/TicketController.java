package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Ticket;
import com.gmail.karpovych.springdemoboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String findAll(Model model) {
        List<Ticket> tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "ticket/ticket-list";
    }

    @GetMapping("/ticket-create")
    public String createUserForm(Ticket ticket) {
        return "ticket/ticket-create";
    }

    @PostMapping("/ticket-create")
    public String createUser(Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("ticket-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer ticketId) {
        ticketService.deleteById(ticketId);
        return "redirect:/tickets";
    }

    @GetMapping("ticket/ticket-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer ticketId, Model model) {
        Ticket ticket = ticketService.findById(ticketId);
        model.addAttribute("ticket", ticket);
        return "ticket/ticket-update";
    }

    @PostMapping("/ticket-update")
    public String updateUser(Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }
}
