package com.example.demo.domain.feed.repository

import com.example.demo.domain.feed.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>{
}