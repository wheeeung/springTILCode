package com.example.demo.domain.feed.controller.dto.response

import com.example.demo.domain.feed.entity.Post
import com.example.demo.domain.user.entity.User

data class PostResponse(
    val title:String?,
    val content: String?,
    val user: User?
){
    constructor(post: Post): this(
        title = feed.title,
        content = feed.content,
        user = feed.user
    )
}