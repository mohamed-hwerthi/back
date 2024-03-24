package com.example.back.serviceImp;

import com.example.back.jiraResponseDto.epics.AllEpicsResponseJira;
import com.example.back.jiraResponseDto.epics.EpicResponseJira;
import com.example.back.serviceDec.EpicsServiceDec;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EpicsServiceImp implements EpicsServiceDec {
    private  final WebClient webClient  ;
    private  final Logger log = LoggerFactory.getLogger(EpicsServiceImp.class);
    @Override
    public Flux<AllEpicsResponseJira> getAllEpicsOfBoard(String cloudId, String token, int boardId) {
        log.info(cloudId);
        log.info(String.valueOf(boardId));
        log.info(token);

        String authorisation= "Bearer "+token ;
        return webClient.get()
                .uri(cloudId+"/rest/agile/1.0/board/"+boardId+"/epic")
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(AllEpicsResponseJira.class) ;
    }

    @Override //n'est pas necessaire  :
    public Flux<EpicResponseJira> getEpicWithId(String cloudId, String token, int epicId) {
        String authorisation ="Bearer "+token  ;
        return webClient.get()
                .uri(cloudId+"/rest/agile/1.0/epic/"+epicId)
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(EpicResponseJira.class) ;
    }
}
