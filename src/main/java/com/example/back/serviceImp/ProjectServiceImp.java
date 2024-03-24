package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.projects.AllProjectsResponse;
import com.example.back.jiraResponseDto.projects.ProjectWithIdResponse;
import com.example.back.serviceDec.ProjectServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectServiceDec {
    private  final WebClient webClient ;
    @Override
    public Flux<AllProjectsResponse> getAllprojects(String cloudId, String token) {
        String authorisation = "Bearer "+token ;
        return webClient.get()
                .uri(cloudId+"/rest/api/2/project" )
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(AllProjectsResponse.class) ;
    }

    @Override
    public Flux<ProjectWithIdResponse> getProjectWithId(String cloudId, String token, String projectId) {
        String authorisation = "Bearer "+token ;
        return webClient.get()
                .uri(cloudId+"/rest/api/2/project/"+projectId )
                .header("Accept"  , "application/json")
                .header("Authorization" ,authorisation )
                .retrieve()
                .bodyToFlux(ProjectWithIdResponse.class) ;

    }
}
