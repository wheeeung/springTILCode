package com.example.demo.domain.feed.exception

import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.error.exception.CustomException

class FeedNotFoundException(errorCode: GlobalErrorCode) : CustomException(errorCode) {

}