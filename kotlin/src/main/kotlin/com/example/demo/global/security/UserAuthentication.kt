package com.example.demo.global.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class UserAuthentication(principal: Any, credentials: Any?) :
    UsernamePasswordAuthenticationToken(principal, credentials) {

}