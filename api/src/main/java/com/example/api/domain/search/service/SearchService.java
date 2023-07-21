package com.example.api.domain.search.service;

import com.example.api.domain.search.controller.dto.request.ImageRequest;
import com.example.api.domain.search.controller.dto.response.ImageResponse;
import com.example.api.global.NaverClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final NaverClient client;

    public ImageResponse getimg(String query) throws UnsupportedEncodingException {
        query = URLEncoder.encode(query, "UTF-8");
        ImageRequest request = new ImageRequest();
        request.setQuery(query);

        return client.imageSearch(request);
    }
}
