package com.example.springtilcode.domain.post.service;

import com.example.springtilcode.domain.post.controller.dto.response.PostResponse;
import com.example.springtilcode.domain.post.entity.Post;
import com.example.springtilcode.domain.post.exception.PostNotFoundException;
import com.example.springtilcode.domain.post.repository.PostRepository;
import com.example.springtilcode.domain.user.entity.User;
import com.example.springtilcode.domain.user.exception.UserNotFoundException;
import com.example.springtilcode.domain.user.repository.UserRepository;
import com.example.springtilcode.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final SecurityUtil securityUtil;
    private final UserRepository userRepository;

    @Transactional
    public void save(String title, String content){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Post post = Post.builder()
                .title(title)
                .content(content)
                .user(user)
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
                .user(post.getUser())
                .build();
    }
}
