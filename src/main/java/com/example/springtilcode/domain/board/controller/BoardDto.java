package com.example.springtilcode.domain.board.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private String writer;
    private String title;
    private String content;
}
