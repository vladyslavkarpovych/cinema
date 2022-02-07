package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
