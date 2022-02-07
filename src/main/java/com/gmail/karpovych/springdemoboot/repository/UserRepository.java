package com.gmail.karpovych.springdemoboot.repository;

import com.gmail.karpovych.springdemoboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
