package com.example.back.serviceImp;

import com.example.back.jiraResponseDto.boards.AllBoardResponseJira;
import com.example.back.jiraResponseDto.priority.JiraPriorityResponse;
import com.example.back.serviceDec.PriorityServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class PriorityServiceImp implements PriorityServiceDec {
    private  final WebClient webClient ;

    @Override
    public Flux<JiraPriorityResponse> getAllpriorities(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/priority")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(JiraPriorityResponse.class);
    }
}

