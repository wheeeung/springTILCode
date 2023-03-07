package com.example.springtilcode.post.service;

import com.example.springtilcode.domain.post.controller.dto.response.PostResponse;
import com.example.springtilcode.domain.post.entity.Post;
import com.example.springtilcode.domain.post.exception.PostNotFoundException;
import com.example.springtilcode.domain.post.repository.PostRepository;
import com.example.springtilcode.domain.post.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void setUser(){
        UserAuthentication userAuthentication = new UserAuthentication("whee050916@gmail.com", null, null);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }

    @Test
    @DisplayName("1. 글 쓰기")
    public void save(){
        String title = "title 1234";
        String content = "content 1234";

        PostResponse postResponse = postService.save(title, content);

        Assertions.assertEquals(postResponse.getTitle(), title);
        Assertions.assertEquals(postResponse.getContent(), content);
    }

    @Test
    @DisplayName("2. 글 삭제")
    public void delete(){
        Integer id = 1;

        postService.delete(id);

        Assertions.assertTrue(postRepository.findById(id).isEmpty());
    }

    @Test
    @DisplayName("3. 글 보기")
    public void getPost(){
        Integer id = 2;

        PostResponse postResponse = postService.getPost(id);
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);

        Assertions.assertEquals(post.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(post.getContent(), postResponse.getContent());
    }
}
