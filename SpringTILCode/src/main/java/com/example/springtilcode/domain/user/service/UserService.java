package com.example.springtilcode.domain.user.service;

import com.example.springtilcode.domain.user.controller.dto.UserResponse;
import com.example.springtilcode.domain.user.entity.User;
import com.example.springtilcode.domain.user.exception.UserNotFoundException;
import com.example.springtilcode.domain.user.repository.UserRepository;
import com.example.springtilcode.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse getUser(){
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
