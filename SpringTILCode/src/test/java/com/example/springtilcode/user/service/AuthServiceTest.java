package com.example.springtilcode.user.service;

import com.example.springtilcode.domain.user.controller.dto.response.TokenResponse;
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
        String email = "test1234@gmail.com";
        String password = "1234";

        authService.signup(email, password);
    }

    @Test
    @DisplayName("login")
    public void login(){
        String email = "test@gmail.com";
        String password = "1234";

        TokenResponse tokenResponse = authService.login(email, password);

        System.out.println(tokenResponse.getAccessToken());
        System.out.println(tokenResponse.getRefreshToken());
    }
}
