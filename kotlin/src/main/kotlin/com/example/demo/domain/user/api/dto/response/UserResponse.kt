package com.example.demo.domain.user.api.dto.response

import com.example.demo.domain.post.domain.Post

data class UserResponse (
    val email: String?,
    val postList: List<Post>?
)