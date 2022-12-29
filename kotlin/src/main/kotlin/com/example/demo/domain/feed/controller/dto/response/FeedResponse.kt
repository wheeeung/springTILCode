package com.example.demo.domain.feed.controller.dto.response

import com.example.demo.domain.feed.entity.Feed

data class FeedResponse(
    val title:String?,
    val content: String?
){
    constructor(feed: Feed): this(
        title = feed.title,
        content = feed.content
    )
}