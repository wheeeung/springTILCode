package com.example.demo.global.error

import com.example.demo.global.error.exception.CustomException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalErrorHandler {
    @ExceptionHandler(CustomException::class)
    protected fun handleException(e: CustomException): ResponseEntity<ErrorResponse>{
        return ResponseEntity.status(e.errorCode.status)
            .body(e.message?.let { ErrorResponse(e.errorCode.status, it) })
    }
}