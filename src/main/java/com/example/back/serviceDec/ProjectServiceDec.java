package com.example.back.serviceDec;
import com.example.back.jiraResponseDto.projects.AllProjectsResponse;
import com.example.back.jiraResponseDto.projects.ProjectWithIdResponse;
import reactor.core.publisher.Flux;

public interface ProjectServiceDec {
    //get all projects  :
    Flux<AllProjectsResponse>getAllprojects(String cloudId , String token  ) ;
    //GET PROject with id  :
    Flux<ProjectWithIdResponse>getProjectWithId(String cloudId , String token , String projectId) ;
}
