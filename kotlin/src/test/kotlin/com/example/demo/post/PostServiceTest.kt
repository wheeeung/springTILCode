package com.example.demo.post

import com.example.demo.domain.post.controller.dto.request.PostRequest
import com.example.demo.domain.post.service.PostService
import com.example.demo.global.security.UserAuthentication
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootTest
class PostServiceTest (
    @Autowired val postService: PostService
){
    @BeforeEach
    fun setUser(){
        val userAuthentication = UserAuthentication("test@gmail.com", null, null)
        SecurityContextHolder.getContext().authentication = userAuthentication
    }

    @Test
    @DisplayName("1. 글 저장")
    fun save(){
        val request = PostRequest("title", "content")

        val postResponse = postService.create(request)

        Assertions.assertEquals(postResponse.title, request.title)
        Assertions.assertEquals(postResponse.content, request.content)
    }

    @Test
    @DisplayName("2. 글 보기")
    fun getPost(){
        postService.getPost(2)
    }

    @Test
    @DisplayName("3. 글 삭제")
    fun delete(){
        postService.delete(1)
    }
}