package com.example.springtilcode.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(400, "user not found"),
    PASSWORD_NOT_MATCH(400, "password did not match"),
    POST_NOT_FOUND(400, "post not found");
    private final int httpStatus;
    private final String message;
}
