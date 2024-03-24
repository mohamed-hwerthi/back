package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.epics.AllEpicsResponseJira;
import com.example.back.jiraResponseDto.epics.EpicResponseJira;
import reactor.core.publisher.Flux;

public interface EpicsServiceDec {
    //get all epics of a board  :
    Flux<AllEpicsResponseJira>getAllEpicsOfBoard(String cloudId , String token , int boardId) ;
    //get allIssues for an epic   :
    Flux<EpicResponseJira>getEpicWithId(String cloudId , String token  ,int epicId) ;
    //get epic by id  :
}
