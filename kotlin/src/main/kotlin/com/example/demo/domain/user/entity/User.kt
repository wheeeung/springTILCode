package com.example.demo.domain.user.entity

import com.example.demo.domain.post.entity.Post
import com.fasterxml.jackson.annotation.JsonIgnore
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

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE])
    var postList: List<Post>?= null
){
    constructor(email: String?, password: String?, passwordEncoder: PasswordEncoder) : this() {
        this.email = email
        this.password = passwordEncoder.encode(password)
    }

    fun editProfile(email: String?){
        this.email = email
    }
}