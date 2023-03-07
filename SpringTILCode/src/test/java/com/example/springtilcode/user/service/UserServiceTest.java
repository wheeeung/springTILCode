package com.example.springtilcode.user.service;

import com.example.springtilcode.domain.user.controller.dto.response.UserResponse;
import com.example.springtilcode.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
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
        UserAuthentication userAuthentication = new UserAuthentication("whee1234@gmail.com", null, null);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }

    @Test
    @DisplayName("getUser")
    public void getUser(){
        UserResponse userResponse = userService.getUser();

        Assertions.assertEquals(userResponse.getEmail(), "whee050916@gmail.com");
    }

    @Test
    public void editProfile(){
        String email = "whee050916@gmail.com";

        UserResponse userResponse = userService.editProfile(email);

        Assertions.assertEquals(userResponse.getEmail(), email);
    }
}
