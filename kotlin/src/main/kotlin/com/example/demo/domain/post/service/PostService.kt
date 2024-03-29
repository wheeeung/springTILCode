package com.example.demo.domain.post.service

import com.example.demo.domain.post.api.dto.request.PostRequest
import com.example.demo.domain.post.api.dto.response.PostResponse
import com.example.demo.domain.post.domain.Post
import com.example.demo.domain.post.exception.PostNotFoundException
import com.example.demo.domain.post.repository.PostRepository
import com.example.demo.domain.user.domain.User
import com.example.demo.domain.user.exception.EmailNotFoundException
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.util.SecurityUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService (
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val securityUtil: SecurityUtil
){
    @Transactional
    fun create(request: PostRequest): PostResponse {
        val user: User = userRepository.findByEmail(securityUtil.getEmail()) ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        val post: Post = postRepository.save(
            Post(
               title = request.title,
               content = request.content,
               user = user
            )
        )
        return PostResponse(post)
    }

    @Transactional
    fun delete(id: Long){
        postRepository.deleteById(id)
    }

    @Transactional
    fun getPost(id: Long): PostResponse {
        val post: Post = postRepository.findById(id).orElseThrow{PostNotFoundException(GlobalErrorCode.BAD_REQUEST)}
        return PostResponse(post)
    }

    @Transactional
    fun editPost(request: PostRequest, id: Long): PostResponse {
        val post = postRepository.findById(id).orElseThrow{PostNotFoundException(GlobalErrorCode.BAD_REQUEST)}
        post.editPost(request.title, request.content)

        postRepository.save(post)

        return PostResponse(post);
    }
}