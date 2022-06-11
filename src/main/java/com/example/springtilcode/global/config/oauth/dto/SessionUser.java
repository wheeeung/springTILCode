package com.example.springtilcode.global.config.oauth.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    @Builder
    public SessionUser(String name, String email){
        this.name = name;
        this.email = email;
    }
}
