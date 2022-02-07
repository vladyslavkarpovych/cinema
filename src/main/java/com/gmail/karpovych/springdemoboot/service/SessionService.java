package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Session;
import com.gmail.karpovych.springdemoboot.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session findById(Integer sessionId) {
        return sessionRepository.getOne(sessionId);
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteById(Integer sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
