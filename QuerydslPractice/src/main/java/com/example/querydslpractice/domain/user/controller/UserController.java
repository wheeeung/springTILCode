package com.example.querydslpractice.domain.user.controller;

import com.example.querydslpractice.domain.user.controller.dto.UserDto;
import com.example.querydslpractice.domain.user.entity.User;
import com.example.querydslpractice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public Page<User> userPage(@RequestBody UserDto userDto) {
        return userService.findAllWithName(userDto);
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }
}