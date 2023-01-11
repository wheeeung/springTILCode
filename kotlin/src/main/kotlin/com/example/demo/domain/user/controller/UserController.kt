package com.example.demo.domain.user.controller

import com.example.demo.domain.user.controller.dto.response.UserResponse
import com.example.demo.domain.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService
) {
    @GetMapping("/user")
    fun getUser() : UserResponse{
        return userService.getUser()
    }
}