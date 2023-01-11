package com.example.demo.domain.user.controller.dto.response

import com.example.demo.domain.post.entity.Post

data class UserResponse (
    val email: String?,
    val postList: List<Post>?
)