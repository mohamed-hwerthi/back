package com.example.back.jiraResponseDto.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusSearchResJira {
    private int startAt;
    private int total;
    private boolean isLast;
    private int maxResults;
    private List<JiraStatus> values;
    private String self;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class JiraStatus {
    private String id;
    private String name;
    private String statusCategory;
    private Scope scope;
    private String description;
    private List<Object> usages;
    private List<Object> workflowUsages;

    // Getters and setters
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
 class Scope {
    private String type;
    private Project project;

    // Getters and setters
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
 class Project {
    private String id;

    // Getters and setters
}