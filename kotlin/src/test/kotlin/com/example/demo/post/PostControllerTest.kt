package com.example.demo.post

import com.example.demo.domain.post.controller.dto.request.PostRequest
import com.example.demo.domain.post.repository.PostRepository
import com.example.demo.domain.post.service.PostService
import com.example.demo.global.security.UserAuthentication
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
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
        println(json)

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
}