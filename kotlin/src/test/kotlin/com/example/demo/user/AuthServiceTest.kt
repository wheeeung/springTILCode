package com.example.demo.user

import com.example.demo.domain.user.service.AuthService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthServiceTest (
    @Autowired
    val authService: AuthService
){
    @Test
    @DisplayName("1. 회원가입")
    fun signup(){
        authService.signup("whee@gmail.com", "1234")
    }

    @Test
    @DisplayName("2. 로그인")
    fun login(){
        val tokenResponse = authService.login("whee@gmail.com", "1234")
        println(tokenResponse)
    }
}