package com.example.api.domain.search.controller;

import com.example.api.domain.search.controller.dto.response.ImageResponse;
import com.example.api.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService service;

    @GetMapping("/imglist")
    public ImageResponse getimg(@RequestParam String query) throws UnsupportedEncodingException {
        return service.getimg(query);
    }
}
