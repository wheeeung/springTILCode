package com.example.springtilcode.domain.post.service;

import com.example.springtilcode.domain.post.entity.Post;
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
}
