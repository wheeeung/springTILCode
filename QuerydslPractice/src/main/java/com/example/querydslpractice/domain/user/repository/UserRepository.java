package com.example.querydslpractice.domain.user.repository;

import com.example.querydslpractice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{
}
