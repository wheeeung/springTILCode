package com.example.demo.global.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding

@ConfigurationPropertiesBinding
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties (
    val secret: String
)