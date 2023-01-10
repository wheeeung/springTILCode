package com.example.springtilcode.domain.post.controller;

import com.example.springtilcode.domain.post.controller.dto.request.PostRequest;
import com.example.springtilcode.domain.post.controller.dto.response.PostResponse;
import com.example.springtilcode.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public void save(@RequestBody PostRequest request){
        postService.save(request.getTitle(), request.getContent());
    }

    @DeleteMapping("/post/{id}")
    public void delete(@PathVariable Integer id){
        postService.delete(id);
    }

    @GetMapping("/post/{id}")
    public PostResponse getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }
}
