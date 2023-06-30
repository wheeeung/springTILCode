package com.example.querydslpractice.domain.user.repository;

import com.example.querydslpractice.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.querydslpractice.domain.user.entity.QUser.user;

public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryCustomImpl(EntityManager em) {
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<User> querydslFindAll() {
        return jpaQueryFactory
                .select(user)
                .from(user)
                .fetch();
    }
}
