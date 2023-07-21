package com.example.api.global;

import com.example.api.domain.search.controller.dto.request.ImageRequest;
import com.example.api.domain.search.controller.dto.response.ImageResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NaverClient {
    private final String naverClientId = "";
    private final String naverSecret = "";
    private final String naverImageSearchUrl = "https://openapi.naver.com/v1/search/image";

    public ImageResponse imageSearch(ImageRequest imageRequest) {
        URI uri = UriComponentsBuilder
                .fromUriString(naverImageSearchUrl)
                .queryParam("query", imageRequest.getQuery())
                .queryParam("display", imageRequest.getDisplay())
                .queryParam("start", imageRequest.getStart())
                .queryParam("sort", imageRequest.getSort())
                .queryParam("filter", imageRequest.getFilter())
                .encode()
                .build()
                .toUri();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", naverClientId)
                .header("X-Naver-Client-Secret", naverSecret)
                .build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(req, String.class);

        ObjectMapper om = new ObjectMapper();
        ImageResponse imageResponse = null;
        try {
            imageResponse = om.readValue(responseEntity.getBody(), ImageResponse.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return imageResponse;
    }
}
