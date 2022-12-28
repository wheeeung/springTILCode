package com.example.demo.domain.feed.service

import com.example.demo.domain.feed.controller.dto.request.FeedRequest
import com.example.demo.domain.feed.controller.dto.response.FeedResponse
import com.example.demo.domain.feed.entity.Feed
import com.example.demo.domain.feed.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FeedService (
    private val feedRepository: FeedRepository
){
    @Transactional
    fun create(request: FeedRequest): FeedResponse{
        val feed: Feed = feedRepository.save(
            Feed(
               title = request.title,
               content = request.content
            )
        )
        return FeedResponse(feed)
    }

    @Transactional
    fun delete(id: Long){
        feedRepository.deleteById(id)
    }

    @Transactional
    fun getFeed(id: Long): FeedResponse{
        val feed: Feed = feedRepository.findById(id).orElseThrow()
        return FeedResponse(feed)
    }
}