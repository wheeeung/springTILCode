package com.example.springtilcode.domain.user.repository;

import com.example.springtilcode.domain.user.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    RefreshToken findByEmail(String email);
}
