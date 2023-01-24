package com.example.springtilcode.user.controller;

import com.example.springtilcode.domain.user.controller.dto.request.EditProfileRequest;
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
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/mypage")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NDAxMDExMSwiZXhwIjoxNjc0MDEzNzExfQ.WAcsoOOMPSTZkK1RnuehpZn7oSjzaxs406Z3_nyooO0")
        ).andExpect(status().isOk());
    }

    @Test
    public void editProfile() throws Exception{
        String email = "wheeabc@gmail.com";

        EditProfileRequest request = new EditProfileRequest(email);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/mypage")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NDUzMTE0OCwiZXhwIjoxNjc0NTM0NzQ4fQ.rT3xRGfYNVk0qMf_5WEv_zAoqdop14OUaRmTrKZ2eVU")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
