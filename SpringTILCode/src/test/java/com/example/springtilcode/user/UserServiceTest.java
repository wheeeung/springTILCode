package com.example.springtilcode.user;

import com.example.springtilcode.domain.user.service.UserService;
import com.example.springtilcode.global.jwt.UserAuthentication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUser(){
        UserAuthentication userAuthentication = new UserAuthentication("whee050916@gmail.com", null, null);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }

    @Test
    @DisplayName("getUser")
    public void getUser(){
        userService.getUser();
    }
}
