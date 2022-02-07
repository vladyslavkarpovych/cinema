package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Session;
import com.gmail.karpovych.springdemoboot.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SessionController {
    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions")
    public String findAll(Model model) {
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions", sessions);
        return "session/sessione-list";
    }

    @GetMapping("/sessione-create")
    public String createSessionForm(Session session) {
        return "session/sessione-create";
    }

    @PostMapping("/sessione-create")
    public String createSession(Session session) {
        sessionService.saveSession(session);
        return "redirect:/sessions";
    }

    @GetMapping("sessione-delete/{id}")
    public String deleteSession(@PathVariable("id") Integer sessionId) {
        sessionService.deleteById(sessionId);
        return "redirect:/sessions";
    }

    @GetMapping("session/sessione-update/{id}")
    public String updateSessionForm(@PathVariable("id") Integer sessionId, Model model) {
        Session sessione = sessionService.findById(sessionId);
        model.addAttribute("sessione", sessione);
        return "session/sessione-update";
    }

    @PostMapping("/sessione-update")
    public String updateSession(Session session) {
        sessionService.saveSession(session);
        return "redirect:/sessions";
    }
}
