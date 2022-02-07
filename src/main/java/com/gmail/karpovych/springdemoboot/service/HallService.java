package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Hall;
import com.gmail.karpovych.springdemoboot.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public Hall findById(Integer hallId) {
        return hallRepository.getOne(hallId);
    }

    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public void deleteById(Integer hallId) {
        hallRepository.deleteById(hallId);
    }
}
