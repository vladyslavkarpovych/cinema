package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionsRepository extends JpaRepository<Promotions, Integer> {
}
