package com.example.demo.domain.user.service

import com.example.demo.domain.user.api.dto.response.UserResponse
import com.example.demo.domain.user.exception.AlreadyExistException
import com.example.demo.domain.user.exception.EmailNotFoundException
import com.example.demo.domain.user.repository.UserRepository
import com.example.demo.global.error.GlobalErrorCode
import com.example.demo.global.util.SecurityUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    val userRepository: UserRepository,
    val securityUtil: SecurityUtil
){
    @Transactional
    fun getUser() : UserResponse {
        val user = userRepository.findByEmail(securityUtil.getEmail())
            ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        return UserResponse(user.email, user.postList)
    }

    @Transactional
    fun editProfile(email: String): UserResponse {
        if(userRepository.findByEmail(email)?.equals(null) == false)
            throw AlreadyExistException(GlobalErrorCode.ALREADY_EXIST)
        val user = userRepository.findByEmail(securityUtil.getEmail())
            ?: throw EmailNotFoundException(GlobalErrorCode.EMAIL_NOT_FOUND)
        user.editProfile(email)
        return UserResponse(user.email, user.postList)
    }
}