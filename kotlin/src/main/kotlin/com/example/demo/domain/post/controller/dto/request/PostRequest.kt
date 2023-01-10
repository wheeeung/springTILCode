package com.example.demo.domain.post.controller.dto.request

import jakarta.validation.constraints.NotBlank

data class PostRequest(
    @NotBlank
    val title:String,

    @NotBlank
    val content:String
)