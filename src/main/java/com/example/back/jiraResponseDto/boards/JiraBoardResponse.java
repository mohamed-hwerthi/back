package com.example.back.jiraResponseDto.boards;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JiraBoardResponse (int id  , String self ,String name , String type , Location location) {}  ;
record   Location(int projectId,String displayName , String projectName , String projectKey , String projectTypeKey ){}

