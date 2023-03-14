package com.example.demo.domain.post.api.dto.response

import com.example.demo.domain.post.domain.Post
import com.example.demo.domain.user.domain.User

data class PostResponse(
    val title:String?,
    val content: String?,
    val user: User?
){
    constructor(post: Post): this(
        title = post.title,
        content = post.content,
        user = post.user
    )
}