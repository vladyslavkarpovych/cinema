package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Genre;
import com.gmail.karpovych.springdemoboot.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String findAll(Model model) {
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        return "genre/genre-list";
    }

    @GetMapping("/genre-create")
    public String createGenreForm(Genre genre) {
        return "genre/genre-create";
    }

    @PostMapping("/genre-create")
    public String createGenre(Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("genre-delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer genreId) {
        genreService.deleteById(genreId);
        return "redirect:/genres";
    }

    @GetMapping("genre/genre-update/{id}")
    public String updateGenreForm(@PathVariable("id") Integer genreId, Model model) {
        Genre genre = genreService.findById(genreId);
        model.addAttribute("genre", genre);
        return "genre/genre-update";
    }

    @PostMapping("/genre-update")
    public String updateGenre(Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/genres";
    }
}
