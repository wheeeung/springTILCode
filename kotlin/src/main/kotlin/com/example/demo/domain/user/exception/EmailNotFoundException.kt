package com.example.demo.domain.user.exception

import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.error.exception.CustomException

class EmailNotFoundException(errorCode: GlobalErrorCode) : CustomException(errorCode){
}