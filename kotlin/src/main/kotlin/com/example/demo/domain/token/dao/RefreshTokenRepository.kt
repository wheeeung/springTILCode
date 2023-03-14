package com.example.demo.domain.token.dao

import com.example.demo.domain.token.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>{
}