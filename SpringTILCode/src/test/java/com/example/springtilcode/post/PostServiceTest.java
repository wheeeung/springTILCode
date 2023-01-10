package com.example.springtilcode.post;

import com.example.springtilcode.domain.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

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
}
