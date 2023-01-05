package com.example.demo.global.jwt

import com.example.demo.global.security.UserAuthentication
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(
    private val jwtProvider: JwtProvider
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authenticationHeader: String? = request.getHeader("Authorization") ?: return filterChain.doFilter(request, response)
        val token = authenticationHeader?.substring("Bearer ".length) ?: return filterChain.doFilter(request, response)
        if(jwtProvider.validation(token)){
            val email = jwtProvider.getEmail(token)
            val userAuthentication = UserAuthentication(email, null)
            SecurityContextHolder.getContext().authentication = userAuthentication
        }

        filterChain.doFilter(request, response)
    }
}