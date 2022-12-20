package com.example.springtilcode.global.jwt;

import com.example.springtilcode.domain.user.entity.RefreshToken;
import com.example.springtilcode.domain.user.repository.RefreshTokenRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenProvider {

    @Value("jwt.secret")
    private String secretKey;
    private final RefreshTokenRepository refreshTokenRepository;

    private final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 60;
    private final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 7;

    public String createAccessToken(String email){
        Claims claims = Jwts.claims().setSubject(email);
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + ACCESS_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createRefreshToken(String email){
        Claims claims = Jwts.claims().setSubject(email);
        Date date = new Date();
        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + REFRESH_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        RefreshToken redis = new RefreshToken(refreshToken, email, REFRESH_TOKEN_VALID_TIME);
        refreshTokenRepository.save(redis);

        return refreshToken;
    }

    public String getEmail(String accessToken){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(accessToken).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

}
