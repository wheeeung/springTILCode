package com.example.demo.domain.user.service

import com.example.demo.domain.user.controller.dto.response.TokenResponse
import com.example.demo.domain.user.entity.User
import com.example.demo.domain.user.exception.AlreadyExistException
import com.example.demo.domain.user.exception.EmailNotFoundException
import com.example.demo.domain.user.exception.PasswordNotMatchesException
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService (
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
){
    @Transactional
    fun signup(email: String, password: String){
        if(userRepository.findByEmail(email)?.equals(null) == false)
            throw AlreadyExistException(GlobalErrorCode.BAD_REQUEST)
        val user = User(email, password, passwordEncoder)
        userRepository.save(user)
    }

    @Transactional
    fun login(email: String, password: String): TokenResponse{
        val user = userRepository.findByEmail(email) ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        if(!passwordEncoder.matches(password, user.password))
            throw PasswordNotMatchesException(GlobalErrorCode.BAD_REQUEST)

        val access = jwtProvider.createAccessToken(email)
        val refresh = jwtProvider.createRefreshToken(email)

        return TokenResponse(access, refresh)
    }
}