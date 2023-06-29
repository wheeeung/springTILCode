package com.example.querydslpractice.domain.user.repository;

import com.example.querydslpractice.domain.user.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> querydslFindAll();
}
