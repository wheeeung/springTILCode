package com.example.springtilcode.post;

import com.example.springtilcode.domain.post.service.PostService;
import com.example.springtilcode.global.jwt.UserAuthentication;
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

    @BeforeEach
    public void setUser(){
        UserAuthentication userAuthentication = new UserAuthentication("whee050916@gmail.com", null, null);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
    }

    @Test
    @DisplayName("1. 글 쓰기")
    public void save(){
        postService.save("title", "content");
    }

    @Test
    @DisplayName("2. 글 삭제")
    public void delete(){
        postService.delete(1);
    }

    @Test
    @DisplayName("3. 글 보기")
    public void getPost(){
        postService.getPost(2);
    }
}
