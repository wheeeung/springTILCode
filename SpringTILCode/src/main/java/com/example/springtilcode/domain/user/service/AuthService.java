package com.example.springtilcode.domain.user.service;

import com.example.springtilcode.domain.user.controller.dto.response.TokenResponse;
import com.example.springtilcode.domain.user.entity.User;
import com.example.springtilcode.domain.user.exception.AlreadyExistException;
import com.example.springtilcode.domain.user.exception.PasswordNotMatchException;
import com.example.springtilcode.domain.user.exception.UserNotFoundException;
import com.example.springtilcode.domain.token.RefreshTokenRepository;
import com.example.springtilcode.domain.user.repository.UserRepository;
import com.example.springtilcode.global.error.ErrorCode;
import com.example.springtilcode.global.jwt.TokenProvider;
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
        if(userRepository.findByEmail(email).isPresent())
            throw new AlreadyExistException(ErrorCode.ALREADY_EXIST);
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
