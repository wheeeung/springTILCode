package com.example.demo.domain.feed.service

import com.example.demo.domain.feed.controller.dto.request.FeedRequest
import com.example.demo.domain.feed.controller.dto.response.FeedResponse
import com.example.demo.domain.feed.entity.Feed
import com.example.demo.domain.feed.exception.FeedNotFoundException
import com.example.demo.domain.feed.repository.FeedRepository
import com.example.demo.domain.user.entity.User
import com.example.demo.domain.user.exception.EmailNotFoundException
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.util.SecurityUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FeedService (
    private val feedRepository: FeedRepository,
    private val userRepository: UserRepository,
    private val securityUtil: SecurityUtil
){
    @Transactional
    fun create(request: FeedRequest): FeedResponse{
        val user: User = userRepository.findByEmail(securityUtil.getEmail()) ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        val feed: Feed = feedRepository.save(
            Feed(
               title = request.title,
               content = request.content,
               user = user
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
        val feed: Feed = feedRepository.findById(id).orElseThrow{FeedNotFoundException(GlobalErrorCode.BAD_REQUEST)}
        return FeedResponse(feed)
    }
}