package com.example.springtilcode.domain.user.exception;

import com.example.springtilcode.global.error.ErrorCode;
import com.example.springtilcode.global.error.exception.CustomException;

public class PasswordNotMatchException extends CustomException {
    public PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
