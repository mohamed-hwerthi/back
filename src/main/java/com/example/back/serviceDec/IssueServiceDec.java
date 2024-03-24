package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.issues.AllIssueResponseJira;
import com.example.back.jiraResponseDto.issues.IssueTypeResponseJira;
import com.example.back.jiraResponseDto.issues.allMM;
import reactor.core.publisher.Flux;

public interface IssueServiceDec {
    // get all issues of A board :
    Flux<AllIssueResponseJira> getAllIssuesOfABoard(String token, String cloudId, int boardId);

    // get all issues of a sprint :
    Flux<allMM> getAllIssuesOfSprint(String token, String cloudId, int boardId, int sprintId);

    // get all issues of an epic :
    Flux<IssueTypeResponseJira> getIssueTypes(String cloudId, String token);
    // 2 methode for getting issuses of sprint :

}
