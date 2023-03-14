package com.example.demo.domain.post.dao

import com.example.demo.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>{
}