package com.example.demo.domain.post.exception

import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.error.exception.CustomException

class PostNotFoundException(errorCode: GlobalErrorCode) : CustomException(errorCode) {

}