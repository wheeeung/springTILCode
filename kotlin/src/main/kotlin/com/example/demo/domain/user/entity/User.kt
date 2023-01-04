package com.example.demo.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String? = null,

    @Column
    var password: String? = null
){
    constructor(email: String?, password: String?, passwordEncoder: PasswordEncoder) : this() {
        this.email = email
        this.password = passwordEncoder.encode(password)
    }
}