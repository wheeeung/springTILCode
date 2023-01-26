package com.example.demo.domain.post.entity

import com.example.demo.domain.user.entity.User
import com.fasterxml.jackson.annotation.JsonIgnore
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User?= null
){
    fun editPost(title: String?, content: String?){
        this.title = title
        this.content = content
    }
}