package com.example.springtilcode.domain.user.exception;

import com.example.springtilcode.global.error.ErrorCode;
import com.example.springtilcode.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
