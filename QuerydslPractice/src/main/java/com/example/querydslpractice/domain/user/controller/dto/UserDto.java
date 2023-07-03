package com.example.querydslpractice.domain.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private int page;
    private int size;
    private String name;
}