package com.example.api.domain.search.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageItem {
    private String title;
    private String link;
    private String thumbnail;
    private String sizeheight;
    private String sizewidth;
}