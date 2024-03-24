package com.example.back.serviceImp;

import com.example.back.jiraResponseDto.issues.AllIssueResponseJira;
import com.example.back.jiraResponseDto.issues.IssueTypeResponseJira;
import com.example.back.serviceDec.IssueServiceDec;
import com.example.back.jiraResponseDto.issues.allMM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class IssueServiceImp implements IssueServiceDec {
    private final WebClient webClient;

    @Override
    public Flux<AllIssueResponseJira> getAllIssuesOfABoard(String token, String cloudId, int boardId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board/" + boardId + "/issue")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(AllIssueResponseJira.class);
    }

    @Override
    public Flux<allMM> getAllIssuesOfSprint(String token, String cloudId, int boardId, int sprintId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board/" + boardId + "/sprint/" + sprintId + "/issue")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(allMM.class);

    }

    @Override
    public Flux<IssueTypeResponseJira> getIssueTypes(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/2/issuetype")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(IssueTypeResponseJira.class);
    }
}
