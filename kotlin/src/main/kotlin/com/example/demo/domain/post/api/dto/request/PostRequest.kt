package com.example.demo.domain.post.api.dto.request

import jakarta.validation.constraints.NotBlank

data class PostRequest(
    @NotBlank
    val title:String,

    @NotBlank
    val content:String
)