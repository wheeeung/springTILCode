package com.example.demo.global.jwt

import com.example.demo.domain.token.entity.RefreshToken
import com.example.demo.domain.token.repository.RefreshTokenRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider (
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
){
    val ACCESSTOKEN_EXP_TIME: Long = 1000L * 60 * 60
    val REFRESHTOKEN_EXP_TIME: Long = 1000L * 60 * 60 * 24 * 7

    fun createAccessToken(email: String): String{
        val claims: Claims = Jwts.claims().setSubject(email)

        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(Date(System.currentTimeMillis() + ACCESSTOKEN_EXP_TIME))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .compact()
    }

    fun createRefreshToken(email: String): String{
        val claims: Claims = Jwts.claims().setSubject(email)

        val refreshToken = Jwts.builder()
            .setClaims(claims)
            .setExpiration(Date(System.currentTimeMillis() + REFRESHTOKEN_EXP_TIME))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .compact()

        val redisRefresh = RefreshToken(refreshToken, email, REFRESHTOKEN_EXP_TIME)
        refreshTokenRepository.save(redisRefresh)

        return refreshToken
    }

    fun getEmail(token: String): String{
        return Jwts.parser().setSigningKey(jwtProperties.secret).parseClaimsJws(token).body.subject
    }

    fun validation(token: String): Boolean{
        val claims: Claims = getAllClaims(token)
        val exp: Date = claims.expiration
        return exp.after(Date())
    }

    private fun getAllClaims(token: String): Claims{
        return Jwts.parser()
            .setSigningKey(jwtProperties.secret)
            .parseClaimsJws(token)
            .body
    }
}