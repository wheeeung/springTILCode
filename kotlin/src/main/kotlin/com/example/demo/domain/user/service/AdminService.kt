package com.example.demo.domain.user.service

import com.example.demo.domain.user.api.dto.response.UserResponse
import com.example.demo.domain.user.domain.Role
import com.example.demo.domain.user.domain.User
import com.example.demo.domain.user.exception.AlreadyExistException
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.error.GlobalErrorCode
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
){
    @Transactional
    fun adminSignup(email: String, password: String): UserResponse{
        if(userRepository.findByEmail(email)?.equals(null) == false)
            throw AlreadyExistException(GlobalErrorCode.ALREADY_EXIST)
        val user = User(email, passwordEncoder.encode(password), Role.ROLE_ADMIN)
        userRepository.save(user)
        return UserResponse(user.email, null)
    }
}