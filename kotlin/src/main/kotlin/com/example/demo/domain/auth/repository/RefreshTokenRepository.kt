package com.example.demo.domain.auth.repository

import com.example.demo.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>{
}