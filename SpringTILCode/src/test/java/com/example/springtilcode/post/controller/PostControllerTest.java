package com.example.springtilcode.post.controller;

import com.example.springtilcode.domain.post.controller.dto.request.PostRequest;
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
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception {
        PostRequest request = new PostRequest("title", "content1234");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/post")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlMDUwOTE2QGdtYWlsLmNvbSIsImlhdCI6MTY3MzgzNzQ0NCwiZXhwIjoxNjczODQxMDQ0fQ.m_95BeTwdB2e8Hv9ao4n8-JOvG9RSXBQ5MVq33nxWIs")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/post/7")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlMDUwOTE2QGdtYWlsLmNvbSIsImlhdCI6MTY3Mzg0MjIwOSwiZXhwIjoxNjczODQ1ODA5fQ.G8_30bXmBOppTB2lCFfRK20WJ8EvYdktdtQCRqYDeV8")
        ).andExpect(status().isOk());
    }
}
