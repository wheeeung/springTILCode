package com.example.demo.user.controller

import com.example.demo.domain.user.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest (
    @Autowired
    val mockMvc: MockMvc,
    @Autowired
    val userService: UserService
){
    @Test
    fun getUser(){
        mockMvc.perform(
            MockMvcRequestBuilders.get("/user")
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlQGdtYWlsLmNvbSIsImV4cCI6MTY3MzY2MTk2OX0.PxM1iNRKBl3fqcum56V7Xiju3PnhNTTmxYbgD6-12sY")
        )
            .andExpect(status().isOk)
    }
}