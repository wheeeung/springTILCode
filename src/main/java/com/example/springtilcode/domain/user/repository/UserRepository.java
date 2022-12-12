package com.example.springtilcode.domain.user.repository;

import com.example.springtilcode.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
