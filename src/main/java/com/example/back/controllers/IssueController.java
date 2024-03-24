package com.example.back.controllers;

import com.example.back.jiraResponseDto.issues.AllIssueResponseJira;
import com.example.back.jiraResponseDto.issues.IssueTypeResponseJira;
import com.example.back.serviceImp.IssueServiceImp;
import com.example.back.jiraResponseDto.issues.allMM;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class IssueController {
    private final IssueServiceImp issueServiceImp;

    @GetMapping("/getIssuesOfABoard/{boardId}")

    public Flux<AllIssueResponseJira> getAllIssuesOfABoard(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int boardId) {
        return issueServiceImp.getAllIssuesOfABoard(token, cloudId, boardId);
    }

    @GetMapping("/AllIssuesOfOneSprint/{boardId}/{sprintId}")

    public Flux<allMM> getAllIssuesOfSprint(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int boardId, @PathVariable int sprintId) {
        return issueServiceImp.getAllIssuesOfSprint(token, cloudId, boardId, sprintId);
    }

    @GetMapping("/issueTypes")
    public Flux<IssueTypeResponseJira> getIssueTypes(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token) {
        return issueServiceImp.getIssueTypes(cloudId, token);
    }
}
