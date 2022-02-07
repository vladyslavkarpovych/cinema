package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
