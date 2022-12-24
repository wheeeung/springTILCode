package com.example.demo.domain.feed.repository

import com.example.demo.domain.feed.entity.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<Feed, Long>{
}