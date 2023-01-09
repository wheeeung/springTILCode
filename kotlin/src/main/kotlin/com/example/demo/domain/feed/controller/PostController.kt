package com.example.demo.domain.feed.controller

import com.example.demo.domain.feed.controller.dto.request.PostRequest
import com.example.demo.domain.feed.controller.dto.response.PostResponse
import com.example.demo.domain.feed.service.PostService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController (
    private val postService: PostService
){
    @PostMapping("/post")
    fun create(@RequestBody request: PostRequest): PostResponse{
        return postService.create(request)
    }

    @DeleteMapping("/post/{id}")
    fun delete(@PathVariable id: Long){
        postService.delete(id)
    }

    @GetMapping("/post/{id}")
    fun getPost(@PathVariable id: Long): PostResponse{
        return postService.getFeed(id)
    }

}