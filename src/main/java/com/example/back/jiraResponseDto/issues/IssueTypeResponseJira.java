package com.example.back.jiraResponseDto.issues;

import lombok.Data;

@Data
public class IssueTypeResponseJira {
    private  String self  ;
    private String id  ;
    private String description  ;
    private String iconUrl ;
    private  String name  ;
    private  Boolean subtask  ;
    private String avatarId  ;
    private int hiearchyLevel  ;
}
