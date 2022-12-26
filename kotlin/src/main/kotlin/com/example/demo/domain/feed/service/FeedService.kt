package com.example.demo.domain.feed.service

import com.example.demo.domain.feed.controller.dto.FeedRequest
import com.example.demo.domain.feed.entity.Feed
import com.example.demo.domain.feed.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FeedService (
    private val feedRepository: FeedRepository
){
    @Transactional
    fun create(request: FeedRequest){
        feedRepository.save(
            Feed(
               title = request.title,
               content = request.content
            )
        )
    }
}