package com.example.demo.user.controller

import com.example.demo.domain.user.controller.dto.request.UserRequest
import com.example.demo.domain.user.service.AuthService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest (
    @Autowired
    val mockMvc: MockMvc,
    @Autowired
    val authService: AuthService
){
    @Test
    fun signup(){
        val request = UserRequest("whee050916@gmail.com", "1234")
        val json = jacksonObjectMapper().writeValueAsString(request)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/signup")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
    }

    @Test
    fun login(){
        val request = UserRequest("whee050916@gmail.com", "1234")
        val json = jacksonObjectMapper().writeValueAsString(request)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/login")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
    }
}