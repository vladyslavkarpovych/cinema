package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
