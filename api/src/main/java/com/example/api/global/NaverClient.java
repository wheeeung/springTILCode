package com.example.api.global;

import com.example.api.domain.search.controller.dto.request.ImageRequest;
import com.example.api.domain.search.controller.dto.response.ImageResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class NaverClient {
    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverSecret;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public List<ImageResponse.ImageItem> imageSearch(ImageRequest imageRequest) {
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

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Client", naverSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = new RestTemplate()
                .exchange(uri, HttpMethod.GET, httpEntity, String.class);

        ObjectMapper om = new ObjectMapper();
        ImageResponse imageResponse = null;
        try {
            imageResponse = om.readValue(responseEntity.getBody(), ImageResponse.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return imageResponse != null ? imageResponse.getItemList() : null;
    }
}
