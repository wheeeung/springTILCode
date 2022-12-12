package com.example.springtilcode.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@AllArgsConstructor
@RedisHash
@Builder
public class RefreshToken {
    @Id
    private String id;

    @Indexed
    private String email;

    @TimeToLive
    private Long expiration;
}
