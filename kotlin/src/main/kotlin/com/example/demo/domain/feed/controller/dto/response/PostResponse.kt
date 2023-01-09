package com.example.demo.domain.feed.controller.dto.response

import com.example.demo.domain.feed.entity.Post
import com.example.demo.domain.user.entity.User

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