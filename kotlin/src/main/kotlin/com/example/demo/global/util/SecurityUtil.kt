package com.example.demo.global.util

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityUtil {
    fun getEmail(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}