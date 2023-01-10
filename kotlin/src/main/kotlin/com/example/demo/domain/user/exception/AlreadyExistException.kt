package com.example.demo.domain.user.exception

import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.error.exception.CustomException

class AlreadyExistException(errorCode: GlobalErrorCode) : CustomException(errorCode) {
}