package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Hall;
import com.gmail.karpovych.springdemoboot.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HallController {
    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping("/halls")
    public String findAll(Model model) {
        List<Hall> halls = hallService.findAll();
        model.addAttribute("halls", halls);
        return "hall/hall-list";
    }

    @GetMapping("/hall-create")
    public String createHallForm(Hall hall) {
        return "hall/hall-create";
    }

    @PostMapping("/hall-create")
    public String createHall(Hall hall) {
        hallService.saveHall(hall);
        return "redirect:/halls";
    }

    @GetMapping("hall-delete/{id}")
    public String deleteHall(@PathVariable("id") Integer hallId) {
        hallService.deleteById(hallId);
        return "redirect:/halls";
    }

    @GetMapping("hall/hall-update/{id}")
    public String updateHallForm(@PathVariable("id") Integer hallId, Model model) {
        Hall hall = hallService.findById(hallId);
        model.addAttribute("hall", hall);
        return "hall/hall-update";
    }

    @PostMapping("/hall-update")
    public String updateHall(Hall hall) {
        hallService.saveHall(hall);
        return "redirect:/halls";
    }
}
