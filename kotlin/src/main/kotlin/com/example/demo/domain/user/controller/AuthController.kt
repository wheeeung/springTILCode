package com.example.demo.domain.user.controller

import com.example.demo.domain.user.controller.dto.request.UserRequest
import com.example.demo.domain.user.controller.dto.response.TokenResponse
import com.example.demo.domain.user.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController (
    private val authService: AuthService
){
    @PostMapping("/signup")
    fun signup(@RequestBody userRequest: UserRequest){
        authService.signup(userRequest.email, userRequest.password)
    }

    @PostMapping("/login")
    fun login(@RequestBody userRequest: UserRequest): TokenResponse{
        return authService.login(userRequest.email, userRequest.password)
    }
}