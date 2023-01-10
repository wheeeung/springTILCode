package com.example.springtilcode.domain.post.repository;

import com.example.springtilcode.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
