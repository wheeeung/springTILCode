package com.example.querydslpractice.domain.user.repository;

import com.example.querydslpractice.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> querydslFindAll();
    Page<User> findAllWithName(Pageable pageable, String name);
}
