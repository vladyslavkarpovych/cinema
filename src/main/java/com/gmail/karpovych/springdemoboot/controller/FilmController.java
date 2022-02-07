package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Film;
import com.gmail.karpovych.springdemoboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String findAll(Model model) {
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        return "film/film-list";
    }

    @GetMapping("/film-create")
    public String createFilmForm(Film film) {
        return "film/film-create";
    }

    @PostMapping("/film-create")
    public String createFilm(Film film) {
        filmService.saveFilm(film);
        return "redirect:/films";
    }

    @GetMapping("film-delete/{id}")
    public String deleteFilm(@PathVariable("id") Integer filmId) {
        filmService.deleteById(filmId);
        return "redirect:/films";
    }

    @GetMapping("film/film-update/{id}")
    public String updateFilmForm(@PathVariable("id") Integer filmId, Model model) {
        Film film = filmService.findById(filmId);
        model.addAttribute("film", film);
        return "film/film-update";
    }

    @PostMapping("/film-update")
    public String updateFilm(Film film) {
        filmService.saveFilm(film);
        return "redirect:/films";
    }
}
