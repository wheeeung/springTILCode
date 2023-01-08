package com.example.demo.global.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class UserAuthentication(principal: Any, credentials: Any?, authority: List<GrantedAuthority>?) :
    UsernamePasswordAuthenticationToken(principal, credentials, authority) {

}