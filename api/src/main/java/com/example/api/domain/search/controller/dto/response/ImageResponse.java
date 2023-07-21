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
    private List<ImageItem> itemList;

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
}
