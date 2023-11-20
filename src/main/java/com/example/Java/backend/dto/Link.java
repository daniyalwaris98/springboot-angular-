package com.example.Java.backend.dto;

import lombok.Data;

@Data
public class Link {

    private Self self;

    @Data
    public class Self {
        private String href;
    }
}
