package com.example.springtilcode.domain.user.controller;

import com.example.springtilcode.domain.user.controller.dto.request.AuthRequest;
import com.example.springtilcode.domain.user.controller.dto.response.TokenResponse;
import com.example.springtilcode.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody AuthRequest request){
        authService.signup(request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody AuthRequest request){
        return authService.login(request.getEmail(), request.getPassword());
    }
}
