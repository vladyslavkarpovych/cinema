package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Film;
import com.gmail.karpovych.springdemoboot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository cinemaRepository) {
        this.filmRepository = cinemaRepository;
    }

    public Film findById(Integer filmId) {
        return filmRepository.getOne(filmId);
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteById(Integer filmId) {
        filmRepository.deleteById(filmId);
    }
}
