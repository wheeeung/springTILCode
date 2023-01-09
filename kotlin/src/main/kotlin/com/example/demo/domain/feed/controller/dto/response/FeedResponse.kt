package com.example.demo.domain.feed.controller.dto.response

import com.example.demo.domain.feed.entity.Feed
import com.example.demo.domain.user.entity.User

data class FeedResponse(
    val title:String?,
    val content: String?,
    val user: User?
){
    constructor(feed: Feed): this(
        title = feed.title,
        content = feed.content,
        user = feed.user
    )
}