package com.example.demo.domain.post.entity

import com.example.demo.domain.user.entity.User
import jakarta.persistence.*

@Entity
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null,

    @Column
    var title: String?= null,

    @Column
    var content: String?= null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User?= null
)