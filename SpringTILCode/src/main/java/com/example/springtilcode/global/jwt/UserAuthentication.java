package com.example.springtilcode.global.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {
    public UserAuthentication(String principal, String credentials,
                              List<GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

}
