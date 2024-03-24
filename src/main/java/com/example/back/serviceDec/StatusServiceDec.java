package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.Status.StatusResponseJira;
import com.example.back.jiraResponseDto.Status.StatusSearchResJira;
import reactor.core.publisher.Flux;

import java.awt.datatransfer.FlavorEvent;

public interface StatusServiceDec {
    //getAllStatus  :
    Flux<StatusResponseJira>getAllStatus(String cloudId , String token ) ;

    //get Status search  :jira :/rest/api/3/statuses/search     :
   Flux<StatusSearchResJira>getBoardStatusJira(String cloudId , String token  ,String projectId) ;
}
