package com.example.demo.domain.user.entity

import com.example.demo.domain.feed.entity.Feed
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String? = null,

    @Column
    var password: String? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE])
    var feedList: List<Feed>?= null
){
    constructor(email: String?, password: String?, passwordEncoder: PasswordEncoder) : this() {
        this.email = email
        this.password = passwordEncoder.encode(password)
    }
}