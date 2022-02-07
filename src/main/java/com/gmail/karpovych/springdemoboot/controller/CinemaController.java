package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Cinema;
import com.gmail.karpovych.springdemoboot.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinemas")
    public String findAll(Model model){
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        return "cinema/cinema-list";
    }

    @GetMapping("/cinema-create")
    public String createCinemaForm(Cinema cinema){
        return "cinema/cinema-create";
    }

    @PostMapping("/cinema-create")
    public String createCinema(Cinema cinema){
        cinemaService.saveCinema(cinema);
        return "redirect:/cinemas";
    }

    @GetMapping("cinema-delete/{id}")
    public String deleteCinema(@PathVariable("id") Integer cinemaId){
        cinemaService.deleteById(cinemaId);
        return "redirect:/cinemas";
    }

    @GetMapping("cinema/cinema-update/{id}")
    public String updateCinemaForm(@PathVariable("id") Integer cinemaId, Model model){
        Cinema cinema = cinemaService.findById(cinemaId);
        model.addAttribute("cinema", cinema);
        return "cinema/cinema-update";
    }

    @PostMapping("/cinema-update")
    public String updateCinema(Cinema cinema){
        cinemaService.saveCinema(cinema);
        return "redirect:/cinemas";
    }
}
