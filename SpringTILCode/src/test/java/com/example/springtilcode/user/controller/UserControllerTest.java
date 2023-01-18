package com.example.springtilcode.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/mypage")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY3NDAxMDExMSwiZXhwIjoxNjc0MDEzNzExfQ.WAcsoOOMPSTZkK1RnuehpZn7oSjzaxs406Z3_nyooO0")
        ).andExpect(status().isOk());
    }
}
