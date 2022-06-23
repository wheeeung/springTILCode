package com.example.springtilcode.domain.user.repository;

import com.example.springtilcode.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("select User.name, User.email from User where User.id in (select User.id from User where User.role = 0)")
    List<User> findByUser();
}
