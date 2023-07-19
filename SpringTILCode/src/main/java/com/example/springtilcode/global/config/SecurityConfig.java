package com.example.springtilcode.global.config;

import com.example.springtilcode.global.jwt.JwtAccessDeniedHandler;
import com.example.springtilcode.global.jwt.JwtAuthenticationEntryPoint;
import com.example.springtilcode.global.jwt.JwtFilter;
import com.example.springtilcode.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .cors()
               .and()
               .csrf().disable()

               .exceptionHandling()
               .authenticationEntryPoint(jwtAuthenticationEntryPoint)
               .accessDeniedHandler(jwtAccessDeniedHandler)

               .and()
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

               .and()
               .authorizeRequests()
               .antMatchers("/signup").permitAll()
               .antMatchers("/login").permitAll()
               .anyRequest().authenticated()

               .and()
               .addFilterBefore(new JwtFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }
}
