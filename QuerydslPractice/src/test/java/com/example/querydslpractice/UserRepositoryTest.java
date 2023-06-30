package com.example.querydslpractice;

import com.example.querydslpractice.domain.user.entity.User;
import com.example.querydslpractice.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void querydslTest() {
        List<User> userList = userRepository.querydslFindAll();

        userList.iterator().forEachRemaining(user -> {
            System.out.println("user = " + user);
        });
    }
}
