package com.example.api.domain.search.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private String lastBuildDate;
    private String total;
    private Integer start;
    private Integer display;
    private List<ImageItem> items;
}
