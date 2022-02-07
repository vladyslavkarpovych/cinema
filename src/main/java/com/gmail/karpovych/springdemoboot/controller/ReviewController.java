package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.Review;
import com.gmail.karpovych.springdemoboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public String findAll(Model model) {
        List<Review> reviews = reviewService.findAll();
        model.addAttribute("reviews", reviews);
        return "review/review-list";
    }

    @GetMapping("/review-create")
    public String createReviewForm(Review review) {
        return "review/review-create";
    }

    @PostMapping("/review-create")
    public String createReview(Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }

    @GetMapping("review-delete/{id}")
    public String deleteReview(@PathVariable("id") Integer reviewId) {
        reviewService.deleteById(reviewId);
        return "redirect:/reviews";
    }

    @GetMapping("review/review-update/{id}")
    public String updateReviewForm(@PathVariable("id") Integer reviewId, Model model) {
        Review review = reviewService.findById(reviewId);
        model.addAttribute("review", review);
        return "review/review-update";
    }

    @PostMapping("/review-update")
    public String updateReview(Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }
}
