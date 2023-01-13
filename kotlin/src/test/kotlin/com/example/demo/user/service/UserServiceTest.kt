package com.example.demo.user.service

import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.domain.user.service.UserService
import com.example.demo.global.security.UserAuthentication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
class UserServiceTest (
    @Autowired val userService: UserService,
    @Autowired val userRepository: UserRepository
){
    @BeforeEach
    fun setUser(){
        val userAuthentication = UserAuthentication("test@gmail.com", null, null)
        SecurityContextHolder.getContext().authentication = userAuthentication
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