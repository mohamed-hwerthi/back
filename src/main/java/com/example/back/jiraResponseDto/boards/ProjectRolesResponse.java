package com.example.back.jiraResponseDto.boards;
import lombok.Data;


@Data
public class ProjectRolesResponse {
    private String atlassianAddonsProjectAccess;
    private String administrator;
    private String viewer;
    private String member;

}
