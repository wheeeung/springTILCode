package com.example.demo.domain.user.api.dto.request

import jakarta.validation.constraints.NotBlank

data class EditProfileRequest(
    @NotBlank
    val email: String
)
