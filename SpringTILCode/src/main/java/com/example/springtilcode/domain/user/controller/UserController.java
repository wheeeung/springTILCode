package com.example.springtilcode.domain.user.controller;

import com.example.springtilcode.domain.user.controller.dto.UserResponse;
import com.example.springtilcode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public UserResponse getUser(){
        return userService.getUser();
    }
}
