package com.example.demo.domain.feed.controller

import com.example.demo.domain.feed.controller.dto.request.FeedRequest
import com.example.demo.domain.feed.controller.dto.response.FeedResponse
import com.example.demo.domain.feed.service.FeedService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedController (
    private val feedService: FeedService
){
    @PostMapping("/feed")
    fun create(@RequestBody request: FeedRequest): FeedResponse{
        return feedService.create(request)
    }

}