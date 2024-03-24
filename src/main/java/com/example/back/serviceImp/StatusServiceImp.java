package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.Status.StatusResponseJira;
import com.example.back.jiraResponseDto.Status.StatusSearchResJira;
import com.example.back.serviceDec.StatusServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StatusServiceImp implements StatusServiceDec {
    private   final WebClient webClient  ;

    @Override
    public Flux<StatusResponseJira> getAllStatus(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/status")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(StatusResponseJira.class);
    }

    @Override
    public Flux<StatusSearchResJira> getBoardStatusJira(String cloudId, String token, String projectId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(cloudId+"/rest/api/3/statuses/search")
                                             .queryParam("projectId" , projectId)
                                             .build())
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(StatusSearchResJira.class);
    }


}

