package com.example.springtilcode.domain.board.entity;

import com.example.springtilcode.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String writer;

    @Column
    private String title;

    @Column
    private String content;

    @JsonIgnoreProperties({"posts"})
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void update(String writer, String title, String content){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
