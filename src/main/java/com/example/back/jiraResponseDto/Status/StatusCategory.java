package com.example.back.jiraResponseDto.Status;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusCategory {
    private String colorName;
    private int id;
    private String key;
    private String name;
    private String self;
}
