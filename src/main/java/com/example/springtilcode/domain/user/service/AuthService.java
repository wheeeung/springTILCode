package com.example.springtilcode.domain.user.service;

import com.example.springtilcode.domain.user.controller.dto.TokenResponse;
import com.example.springtilcode.domain.user.controller.dto.UserResponse;
import com.example.springtilcode.domain.user.entity.User;
import com.example.springtilcode.domain.user.exception.PasswordNotMatchException;
import com.example.springtilcode.domain.user.exception.UserNotFoundException;
import com.example.springtilcode.domain.user.repository.RefreshTokenRepository;
import com.example.springtilcode.domain.user.repository.UserRepository;
import com.example.springtilcode.global.jwt.TokenProvider;
import com.example.springtilcode.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public void signup(String email, String password){
        User user = new User(email, password, passwordEncoder);
        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(String email, String password){
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new PasswordNotMatchException();
        }
        String accessToken = tokenProvider.createAccessToken(email);
        String refreshToken = tokenProvider.createRefreshToken(email);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
