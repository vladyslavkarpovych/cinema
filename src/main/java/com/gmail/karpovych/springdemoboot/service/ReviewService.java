package com.gmail.karpovych.springdemoboot.service;

import com.gmail.karpovych.springdemoboot.model.Promotions;
import com.gmail.karpovych.springdemoboot.model.Review;
import com.gmail.karpovych.springdemoboot.repository.PromotionsRepository;
import com.gmail.karpovych.springdemoboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review findById(Integer reviewId) {
        return reviewRepository.getOne(reviewId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteById(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
