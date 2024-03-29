package com.example.demo.domain.user.domain

import com.example.demo.domain.post.domain.Post
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String? = null,

    @Column
    var password: String? = null,

    @Column
    @Enumerated(value = EnumType.STRING)
    var role: Role? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE])
    var postList: List<Post>?= null
){
    constructor(email: String?, password: String?, role: Role?) : this() {
        this.email = email
        this.password = password
        this.role = role
    }

    fun editProfile(email: String?){
        this.email = email
    }
}