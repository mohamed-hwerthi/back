package com.example.back.jiraResponseDto.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;


@Data
public class CloudIdResponse {
    private String id;
    private String url;
    private String name;
    @JsonIgnore
    private String avatarUrl;
    @JsonIgnore
    private  List<String> scopes ;
}
