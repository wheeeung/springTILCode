package com.example.springtilcode.domain.user.entity;

import com.example.springtilcode.domain.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String authority;

    @Column
    private Role role;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Board> posts;

    public User update(String name){
        this.name = name;
        return this;
    }
}
