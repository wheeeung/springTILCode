package com.example.springtilcode.global.config.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final UserDetailService userDetailsService;

    @Value("${spring.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(String userId){return makingToken(userId, "access", 7200L);}

    public String generateRefreshToken(String userId){return makingToken(userId, "refresh", 172800L);}

    public boolean validateAccessToken(String token) {
        return validateToken(token);
    }

    public boolean validateRefreshToken(String token){return validateToken(token);}

    public String getId(String token){
        try {
            return Jwts.parser().setSigningKey(encodingSecretKey()).parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e){
            throw null;
        }
    }

    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){

            return token.substring(7);
        }
        return null;
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token){
        UserDetails details =userDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(details, "",details.getAuthorities());
    }

    private boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(encodingSecretKey()).build().parseClaimsJws(token);
            return true;
        }catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e){
            log.info("잘못된 jwt 서명입니다");
        }catch(ExpiredJwtException e){
            log.info("만료된 jwt 토큰입니다.");
        }catch (UnsupportedJwtException e){
            log.info("지원되지 않는 jwt 토큰입니다.");
        }catch (IllegalStateException e){
            log.info("jwt 토큰이 잘못되었습니다.");
        }
        return false;
    }

    private String makingToken(String value, String type, Long time){
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + (time * 1000L)))
                .signWith(SignatureAlgorithm.HS512, encodingSecretKey())
                .setIssuedAt(new Date())
                .setSubject(value)
                .claim("type",type)
                .compact();
    }

    public String encodingSecretKey(){
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}
