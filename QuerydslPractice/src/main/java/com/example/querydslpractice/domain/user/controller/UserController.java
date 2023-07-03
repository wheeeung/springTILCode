package com.example.querydslpractice.domain.user.controller;

import com.example.querydslpractice.domain.user.controller.dto.UserDto;
import com.example.querydslpractice.domain.user.entity.User;
import com.example.querydslpractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public Page<User> userPage(@RequestBody UserDto userDto) {
        Pageable pageable = PageRequest.of(userDto.getPage(), userDto.getSize());
        return userRepository.findAllWithName(pageable, userDto.getName());
    }
}