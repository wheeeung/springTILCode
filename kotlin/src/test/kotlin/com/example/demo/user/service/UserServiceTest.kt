package com.example.demo.user.service

import com.example.demo.domain.user.dao.UserRepository
import com.example.demo.domain.user.application.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
class UserServiceTest (
    @Autowired val userService: UserService,
    @Autowired val userRepository: UserRepository
){
    @BeforeEach
    fun setUser(){
        val authentication : Authentication = UsernamePasswordAuthenticationToken("test@gmail.com", "", null)
        SecurityContextHolder.getContext().authentication = authentication
    }

    @Test
    fun getUser(){
        val email = "test@gmail.com"

        val userResponse = userService.getUser()
        val user = userRepository.findByEmail(email)

        if (user != null) {
            Assertions.assertEquals(userResponse.email, user.email)
        }
    }

    @Test
    fun editProfile(){
        val newEmail = "testcode@gmail.com"

        val userResponse = userService.editProfile(newEmail)

        Assertions.assertEquals(userResponse.email, newEmail)
    }
}