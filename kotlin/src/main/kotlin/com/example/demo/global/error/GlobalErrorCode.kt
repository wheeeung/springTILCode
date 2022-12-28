package com.example.demo.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    status: HttpStatus,
    message: String
) {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "bad request");

    val status: Int = status.value()
    val message: String = message
}