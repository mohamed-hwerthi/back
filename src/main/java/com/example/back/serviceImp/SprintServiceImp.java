package com.example.back.serviceImp;

import com.example.back.serviceImp.BoardServiceImp;
import com.example.back.jiraResponseDto.sprints.AllSprintsResponseJira;
import com.example.back.jiraResponseDto.sprints.SprintResponseJira;
import com.example.back.serviceDec.SprintServiceDec;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class SprintServiceImp  implements SprintServiceDec {
private final   WebClient webClient ;
    private final Logger log = LoggerFactory.getLogger(BoardServiceImp.class) ;

    @Override
    public Flux<AllSprintsResponseJira> getAllSprints(String cloudId, String token, int boardId) {
        String authorisation ="Bearer "+token  ;

        return   webClient.get()
                .uri(cloudId+"/rest/agile/1.0/board/"+boardId+"/sprint")
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(AllSprintsResponseJira.class) ;
    }

    @Override
    public Flux<SprintResponseJira> getSprintWithId(String cloudId, String token, int sprintId) {
        String authorisation ="Bearer "+token ;
        return   webClient.get()
                .uri(cloudId+"/rest/agile/1.0/sprint/"+sprintId)
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(SprintResponseJira.class) ;
    }
}
