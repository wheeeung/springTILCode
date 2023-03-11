package com.example.demo.global.user

import com.example.demo.domain.user.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(val user: User) : UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = arrayListOf(SimpleGrantedAuthority(user.role?.name))

    override fun getPassword(): String? = user.password

    override fun getUsername(): String? = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}