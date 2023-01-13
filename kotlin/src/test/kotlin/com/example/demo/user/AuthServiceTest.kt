package com.example.demo.user

import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.domain.user.service.AuthService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthServiceTest (
    @Autowired
    val authService: AuthService,
    @Autowired
    val userRepository: UserRepository
){
    @Test
    @DisplayName("1. 회원가입")
    fun signup(){
        val email = "whee@gmail.com"
        val password = "1234"

        val userResponse = authService.signup(email, password)
        val findUser = userRepository.findByEmail(email)

        if (findUser != null) {
            Assertions.assertEquals(findUser.email, userResponse.email)
        }
    }

    @Test
    @DisplayName("2. 로그인")
    fun login(){
        val email = "whee@gmail.com"
        val password = "1234"

        val tokenResponse = authService.login(email, password)
        println(tokenResponse)
    }
}