package com.example.springtilcode.domain.post.controller.dto.response;

import com.example.springtilcode.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private String title;
    private String content;
    private User user;
}
