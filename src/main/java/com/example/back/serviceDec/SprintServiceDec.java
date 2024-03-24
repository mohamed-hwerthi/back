package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.sprints.AllSprintsResponseJira;
import com.example.back.jiraResponseDto.sprints.SprintResponseJira;
import reactor.core.publisher.Flux;

public interface SprintServiceDec {
    //getAllSprints :
    Flux<AllSprintsResponseJira>getAllSprints(String cloudId , String token  , int boardId) ;
    //getSprintWithId .
    Flux<SprintResponseJira>getSprintWithId(String cloudId , String token  , int sprintId) ;

}
