package com.example.demo.domain.post.dto.request

import jakarta.validation.constraints.NotBlank

data class PostRequest(
    @NotBlank
    val title:String,

    @NotBlank
    val content:String
)