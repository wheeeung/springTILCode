package com.example.demo.domain.auth.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
data class RefreshToken (
    @Id
    val token: String?,

    @Indexed
    val email: String?,

    @TimeToLive
    val expiration: Long?
)