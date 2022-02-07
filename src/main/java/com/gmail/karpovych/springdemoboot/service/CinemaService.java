package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Cinema;
import com.gmail.karpovych.springdemoboot.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema findById(Integer cinemaId) {
        return cinemaRepository.getOne(cinemaId);
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public void deleteById(Integer cinemaId) {
        cinemaRepository.deleteById(cinemaId);
    }
}
