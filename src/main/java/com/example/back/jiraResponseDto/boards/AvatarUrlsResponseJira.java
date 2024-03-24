package com.example.back.jiraResponseDto.boards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvatarUrlsResponseJira {
    @JsonProperty("24x24")
    private String size24x24;
    @JsonProperty("16x16")
    private String size16x16;
    @JsonProperty("32x32")
    private String size32x32;
    @JsonProperty("48x48")
    private String size48x48;
}
