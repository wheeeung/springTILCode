package com.example.springtilcode.global.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecurityUtil {
    public static String getEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
