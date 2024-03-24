package com.example.back.serviceImp;

import com.example.back.jiraResponseDto.boards.*;
import com.example.back.serviceDec.BoardServiceDec;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Service
public class BoardServiceImp implements BoardServiceDec {
    private final WebClient webClient;
    private final Logger log = LoggerFactory.getLogger(BoardServiceImp.class);


    public BoardServiceImp(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
    }

    //get a board   :
    public Flux<AllBoardResponseJira> getAllBoard(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(AllBoardResponseJira.class);
    }


    @Override
    public Flux<JiraBoardResponse> getBoardWtihId(String cloudId, String token, int boardId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board/" + boardId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(JiraBoardResponse.class);
    }

    @Override
    public Flux<BoardConfig> getBoardConfiguration(String cloudId, String token, int boardId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board/{boardId}/configuration", boardId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(BoardConfig.class);
    }

    @Override
    public Flux<VersionResponse> getAllVersionOfABoard(String cloudId, String token, int boardId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/agile/1.0/board/{boardId}/version", boardId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(VersionResponse.class);
    }

    @Override
    public Flux<ProjectRolesResponse> getRolesOfProjet(String cloudId, String token, int projectId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/2/project/{projectIdOrKey}/role", projectId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(ProjectRolesResponse.class);

    }
}