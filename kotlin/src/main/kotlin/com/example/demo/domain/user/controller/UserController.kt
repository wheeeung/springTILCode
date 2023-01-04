package com.example.demo.domain.user.controller

import com.example.demo.domain.user.controller.dto.request.UserRequest
import com.example.demo.domain.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    private val userService: UserService
){
    @PostMapping("/signup")
    fun signup(@RequestBody userRequest: UserRequest){
        userService.signup(userRequest.email, userRequest.password)
    }
}