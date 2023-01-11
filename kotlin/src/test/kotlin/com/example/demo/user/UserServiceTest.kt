package com.example.demo.user

import com.example.demo.domain.user.service.UserService
import com.example.demo.global.security.UserAuthentication
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
class UserServiceTest (
    @Autowired val userService: UserService
){
    @BeforeEach
    fun setUser(){
        val userAuthentication = UserAuthentication("whee050916@gmail.com", null, null)
        SecurityContextHolder.getContext().authentication = userAuthentication
    }

    @Test
    fun getUser(){
        userService.getUser()
    }

    @Test
    fun editProfile(){
        userService.editProfile("whee050916@gmail.com")
    }
}