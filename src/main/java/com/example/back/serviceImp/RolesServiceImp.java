package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.roles.RolesDetailsOfProject;
import com.example.back.jiraResponseDto.roles.RolesResponseJira;
import com.example.back.serviceDec.RolesServicesDec;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RolesServiceImp  implements RolesServicesDec {
    private final WebClient webClient;
    private final Logger log = LoggerFactory.getLogger(RolesServiceImp.class) ;

    @Override
    public Flux<RolesResponseJira> getAllRolesOfAllProjects(String cloudId , String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/role")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(RolesResponseJira.class);


    }

    @Override
    public Flux<RolesDetailsOfProject> getAllRolesDetailsOfProject(String cloudId, String token, String projectId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/project/{projectIdOrKey}/roledetails" , projectId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(RolesDetailsOfProject.class);
    }
}
