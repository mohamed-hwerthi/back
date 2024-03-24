package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.users.UsersReponseJira;
import com.example.back.serviceDec.UsersServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
public class UsersServiceImp implements UsersServiceDec {
    private  final WebClient webClient ;

    @Override
    public Flux<UsersReponseJira> getAllUsers(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/users/search")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(UsersReponseJira.class);
    }
}

