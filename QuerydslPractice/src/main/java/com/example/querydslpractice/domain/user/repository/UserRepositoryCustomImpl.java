package com.example.querydslpractice.domain.user.repository;

import com.example.querydslpractice.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

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

    @Override
    public Page<User> findAllWithName(Pageable pageable, String name) {
        List<User> userList = jpaQueryFactory
                .select(user)
                .from(user)
                .where(user.name.eq(name))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(userList, pageable, userList.size());
    }
}
