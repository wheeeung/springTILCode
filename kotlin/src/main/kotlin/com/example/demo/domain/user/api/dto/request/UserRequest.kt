package com.example.demo.domain.user.api.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserRequest(
    @NotBlank
    @Email
    val email: String,

    @NotBlank
    val password: String
)
