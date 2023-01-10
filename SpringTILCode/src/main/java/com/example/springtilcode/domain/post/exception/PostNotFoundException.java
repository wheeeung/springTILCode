package com.example.springtilcode.domain.post.exception;

import com.example.springtilcode.global.error.ErrorCode;
import com.example.springtilcode.global.error.exception.CustomException;

public class PostNotFoundException extends CustomException {
    public PostNotFoundException(){
        super(ErrorCode.POST_NOT_FOUND);
    }
}
