package com.example.back.jiraResponseDto.Status;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponseJira {
    private String description;
    private String iconUrl;
    private String id;
    private String name;
    private String self;
    private StatusCategory statusCategory;
}
