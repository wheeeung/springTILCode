package com.example.springtilcode.domain.user.controller;

import com.example.springtilcode.domain.user.controller.dto.AuthRequest;
import com.example.springtilcode.domain.user.controller.dto.TokenResponse;
import com.example.springtilcode.domain.user.controller.dto.UserResponse;
import com.example.springtilcode.domain.user.service.AuthService;
import com.example.springtilcode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody AuthRequest request){
        authService.signup(request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody AuthRequest request){
        return authService.login(request.getEmail(), request.getPassword());
    }

    @GetMapping("/mypage")
    public UserResponse getUser(){
        return userService.getUser();
    }
}
