package com.example.springtilcode.domain.user.controller;

import com.example.springtilcode.domain.user.controller.dto.QuerydslDto;
import com.example.springtilcode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public QuerydslDto getUserInfo(@PathVariable long id){
        return userService.findUserInfo(id);
    }
}
