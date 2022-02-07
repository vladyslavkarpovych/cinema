package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Promotions;
import com.gmail.karpovych.springdemoboot.service.PromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PromotionsController {
    private final PromotionsService promotionsService;

    @Autowired
    public PromotionsController(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @GetMapping("/promotions")
    public String findAll(Model model) {
        List<Promotions> promotions = promotionsService.findAll();
        model.addAttribute("promotions", promotions);
        return "promotions/promotions-list";
    }

    @GetMapping("/promotions-create")
    public String createUserForm(Promotions promotions) {
        return "promotions/promotions-create";
    }

    @PostMapping("/promotions-create")
    public String createPromotions(Promotions promotions) {
        promotionsService.savePromotions(promotions);
        return "redirect:/promotions";
    }

    @GetMapping("promotions-delete/{id}")
    public String deletePromotions(@PathVariable("id") Integer promotionsId) {
        promotionsService.deleteById(promotionsId);
        return "redirect:/promotions";
    }

    @GetMapping("promotions/promotions-update/{id}")
    public String updatePromotionsForm(@PathVariable("id") Integer promotionsId, Model model) {
        Promotions promotion = promotionsService.findById(promotionsId);
        model.addAttribute("promotion", promotion);
        return "promotions/promotions-update";
    }

    @PostMapping("/promotions-update")
    public String updatePromotions(Promotions promotions) {
        promotionsService.savePromotions(promotions);
        return "redirect:/promotions";
    }
}
