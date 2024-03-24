package com.example.back.jiraResponseDto.priority;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraPriorityResponse {
    private String self;
    private String statusColor;
    private String description;
    private String iconUrl;
    private String name;
    private String id;
}
