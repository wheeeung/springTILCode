package com.example.demo.domain.post.repository

import com.example.demo.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>{
}