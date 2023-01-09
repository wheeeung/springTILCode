package com.example.demo.domain.feed.entity

import com.example.demo.domain.user.entity.User
import jakarta.persistence.*

@Entity
data class Feed (
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