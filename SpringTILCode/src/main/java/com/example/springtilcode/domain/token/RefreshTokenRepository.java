package com.example.springtilcode.domain.token;

import com.example.springtilcode.domain.token.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    RefreshToken findByEmail(String email);
}
