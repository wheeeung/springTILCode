package com.example.demo.domain.user.service

import com.example.demo.domain.user.entity.User
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
){
    @Transactional
    fun signup(email: String, password: String){
        val user = User(email, password, passwordEncoder)
        userRepository.save(user)
    }
}