package com.example.api.domain.search.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequest {
    private String query;
    private Integer display = 20;
    private Integer start = 1;
    private String sort = "sim";
    private String filter = "all";

    public void setQuery(String query){
        this.query = query;
    }
}
