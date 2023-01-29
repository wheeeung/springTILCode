package com.example.demo.post.controller

import com.example.demo.domain.post.controller.dto.request.PostRequest
import com.example.demo.domain.post.service.PostService
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
class PostControllerTest (
    @Autowired
    val mvc: MockMvc,
    @Autowired
    val postService: PostService
){

    @Test
    fun save(){
        val postRequest = PostRequest("title1234", "content1234")

        val json = jacksonObjectMapper().writeValueAsString(postRequest)

        mvc.perform(
            MockMvcRequestBuilders.post("/post")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY3MzU5MTczMX0.KQlL5Er1cx6K00DIzwPqz8_87su6Z5ajb8xdjqnAnFk")
        ).andExpect(status().isOk)
    }

    @Test
    fun getPost(){
        mvc.perform(
            MockMvcRequestBuilders.get("/post/7")
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY3MzU5MTczMX0.KQlL5Er1cx6K00DIzwPqz8_87su6Z5ajb8xdjqnAnFk")
        ).andExpect(status().isOk)
    }

    @Test
    fun delete(){
        mvc.perform(
            MockMvcRequestBuilders.delete("/post/18")
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImV4cCI6MTY3MzU5MTczMX0.KQlL5Er1cx6K00DIzwPqz8_87su6Z5ajb8xdjqnAnFk")
        ).andExpect(status().isOk)
    }

    @Test
    fun editPost(){
        val postRequest = PostRequest("title", "content")

        val json = jacksonObjectMapper().writeValueAsString(postRequest)

        mvc.perform(
            MockMvcRequestBuilders.patch("/post/23")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aGVlQGdtYWlsLmNvbSIsImV4cCI6MTY3NDk3MjQwM30.0s0KjJRF9zSsnBjxDNRoLTKzXD7cnp2M34RJYAIBV2M")
        ).andExpect(status().isOk)
    }
}