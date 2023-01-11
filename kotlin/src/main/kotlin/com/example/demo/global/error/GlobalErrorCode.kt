package com.example.demo.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    status: HttpStatus,
    message: String
) {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "bad request"),
    EMAIL_NOT_FOUND(HttpStatus.BAD_REQUEST, "email not found"),
    ALREADY_EXIST(HttpStatus.BAD_REQUEST, "already exist");

    val status: Int = status.value()
    val message: String = message
}