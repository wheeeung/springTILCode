package com.example.demo.global.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenProvider (
    val jwtProperties: JwtProperties
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