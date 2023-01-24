package com.example.springtilcode.domain.user.controller;

import com.example.springtilcode.domain.user.controller.dto.request.EditProfileRequest;
import com.example.springtilcode.domain.user.controller.dto.response.UserResponse;
import com.example.springtilcode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public UserResponse getUser(){
        return userService.getUser();
    }

    @PatchMapping("/mypage")
    public UserResponse editProfile(@RequestBody @Valid EditProfileRequest request){
        return userService.editProfile(request.getEmail());
    }
}
