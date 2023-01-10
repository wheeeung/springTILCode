package com.example.springtilcode.domain.post.service;

import com.example.springtilcode.domain.post.controller.dto.response.PostResponse;
import com.example.springtilcode.domain.post.entity.Post;
import com.example.springtilcode.domain.post.exception.PostNotFoundException;
import com.example.springtilcode.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void save(String title, String content){
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();
        postRepository.save(post);
    }

    @Transactional
    public void delete(Integer id){
        postRepository.deleteById(id);
    }

    @Transactional
    public PostResponse getPost(Integer id){
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
