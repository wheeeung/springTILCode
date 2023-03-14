package com.example.demo.domain.user.api.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)
