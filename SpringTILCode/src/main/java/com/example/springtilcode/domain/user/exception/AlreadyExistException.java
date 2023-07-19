package com.example.springtilcode.domain.user.exception;

import com.example.springtilcode.global.error.ErrorCode;
import com.example.springtilcode.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException(ErrorCode errorCode){
        super(errorCode);
    }
}
