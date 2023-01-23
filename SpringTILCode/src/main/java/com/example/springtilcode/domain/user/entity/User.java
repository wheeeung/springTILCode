package com.example.springtilcode.domain.user.entity;

import com.example.springtilcode.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> postList;

    public User(String email, String password, PasswordEncoder passwordEncoder){
        this.email = email;
        this.password = passwordEncoder.encode(password);
    }

    public void editProfile(String email){
        this.email = email;
    }
}
