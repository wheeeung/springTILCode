package com.example.demo.post.service

import com.example.demo.domain.post.controller.dto.request.PostRequest
import com.example.demo.domain.post.exception.PostNotFoundException
import com.example.demo.domain.post.repository.PostRepository
import com.example.demo.domain.post.service.PostService
import com.example.demo.global.error.GlobalErrorCode
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
    @Autowired val postService: PostService,
    @Autowired val postRepository: PostRepository
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
        val id: Long = 12

        val postResponse = postService.getPost(id)
        val post = postRepository.findById(id).orElseThrow{PostNotFoundException(GlobalErrorCode.BAD_REQUEST)}

        Assertions.assertEquals(postResponse.title, post.title)
        Assertions.assertEquals(postResponse.content, post.content)
        Assertions.assertEquals(postResponse.user?.email, post.user?.email)
    }

    @Test
    @DisplayName("3. 글 삭제")
    fun delete(){
        val id: Long = 3

        postService.delete(id)
        val post = postRepository.findById(id)

        Assertions.assertEquals(post.isEmpty, true)
    }
}