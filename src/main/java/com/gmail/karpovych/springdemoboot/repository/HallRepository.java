package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Integer> {
}
