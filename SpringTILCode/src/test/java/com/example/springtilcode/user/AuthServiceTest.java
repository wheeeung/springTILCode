package com.example.springtilcode.user;

import com.example.springtilcode.domain.user.controller.dto.TokenResponse;
import com.example.springtilcode.domain.user.service.AuthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    @DisplayName("signup")
    public void signup(){
        authService.signup("test@gmail.com", "1234");
    }

    @Test
    @DisplayName("login")
    public void login(){
        authService.login("test@gmail.com", "1234");
    }
}
