package com.example.demo.domain.user.service

import com.example.demo.domain.user.api.dto.response.TokenResponse
import com.example.demo.domain.user.api.dto.response.UserResponse
import com.example.demo.domain.user.domain.Role
import com.example.demo.domain.user.domain.User
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
    fun signup(email: String, password: String): UserResponse {
        if(userRepository.findByEmail(email)?.equals(null) == false)
            throw AlreadyExistException(GlobalErrorCode.ALREADY_EXIST)
        val user = User(email, passwordEncoder.encode(password), Role.ROLE_USER)
        userRepository.save(user)
        return UserResponse(user.email, null)
    }

    @Transactional
    fun login(email: String, password: String): TokenResponse {
        val user = userRepository.findByEmail(email) ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        if(!passwordEncoder.matches(password, user.password))
            throw PasswordNotMatchesException(GlobalErrorCode.BAD_REQUEST)

        val access = jwtProvider.createAccessToken(email, user.role)
        val refresh = jwtProvider.createRefreshToken(email)

        return TokenResponse(access, refresh)
    }
}