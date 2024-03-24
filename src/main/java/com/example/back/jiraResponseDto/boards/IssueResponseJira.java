package com.example.back.jiraResponseDto.boards;


import lombok.Data;

@Data
public class IssueResponseJira {
    private String id;
    private String key;
    private TimeTrackingResponseJira timeTracking;
    private ProjectResponseJira project;
    private EpicResponseJira epic;

}
