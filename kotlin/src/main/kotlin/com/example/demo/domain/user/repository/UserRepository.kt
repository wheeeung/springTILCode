package com.example.demo.domain.user.repository

import com.example.demo.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByEmail(email: String): User?
}