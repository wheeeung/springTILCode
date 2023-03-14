package com.example.demo.domain.user.api

import com.example.demo.domain.user.dto.request.EditProfileRequest
import com.example.demo.domain.user.dto.response.UserResponse
import com.example.demo.domain.user.application.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService
) {
    @GetMapping("/user")
    fun getUser() : UserResponse {
        return userService.getUser()
    }

    @PatchMapping("/user")
    fun editProfile(@Valid @RequestBody request: EditProfileRequest) : UserResponse {
        return userService.editProfile(request.email)
    }
}