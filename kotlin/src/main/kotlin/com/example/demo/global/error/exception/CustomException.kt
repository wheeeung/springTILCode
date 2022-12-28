package com.example.demo.global.error.exception

import com.example.demo.global.error.GlobalErrorCode

class CustomException(
    val errorCode: GlobalErrorCode
): RuntimeException() {
}