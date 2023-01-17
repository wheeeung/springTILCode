package com.example.springtilcode.user.controller;

import com.example.springtilcode.domain.user.controller.dto.AuthRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void signup() throws Exception {
        String email = "whee123@gmail.com";
        String password = "1234";

        AuthRequest authRequest = new AuthRequest(email, password);
        String json = objectMapper.writeValueAsString(authRequest);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/signup")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void login() throws Exception{
        String email = "whee123@gmail.com";
        String password = "1234";

        AuthRequest authRequest = new AuthRequest(email, password);
        String json = objectMapper.writeValueAsString(authRequest);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/login")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }
}
