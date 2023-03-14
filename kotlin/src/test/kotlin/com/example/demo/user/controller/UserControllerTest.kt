package com.example.demo.user.controller

import com.example.demo.domain.user.dto.request.EditProfileRequest
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
class UserControllerTest (
    @Autowired
    val mockMvc: MockMvc
){
    @Test
    fun getUser(){
        mockMvc.perform(
            MockMvcRequestBuilders.get("/user")
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlQGdtYWlsLmNvbSIsImV4cCI6MTY3MzY2MTk2OX0.PxM1iNRKBl3fqcum56V7Xiju3PnhNTTmxYbgD6-12sY")
        )
            .andExpect(status().isOk)
    }

    @Test
    fun editProfile(){
        val request = EditProfileRequest("whee1234@gmail.com")
        val json = jacksonObjectMapper().writeValueAsString(request)

        mockMvc.perform(
            MockMvcRequestBuilders.patch("/user")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlQGdtYWlsLmNvbSIsImV4cCI6MTY3Mzc5NDI1NH0.dgqn2Y4jtNJvoXBYxeFeDV6Ujsll4cN6GPUR_pgd_5o")
        )
            .andExpect(status().isOk)
    }
}