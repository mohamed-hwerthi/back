package com.example.back.controllers;
import com.example.back.jiraResponseDto.projects.AllProjectsResponse;
import com.example.back.jiraResponseDto.projects.ProjectWithIdResponse;
import com.example.back.serviceImp.ProjectServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectControllerJira {
    private  final ProjectServiceImp projectServiceImp ;
    private  final Logger log= LoggerFactory.getLogger(ProjectControllerJira.class) ;
@GetMapping("/getAllProjects")
    public Flux<AllProjectsResponse> getAllprojects(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token) {
        return projectServiceImp.getAllprojects(cloudId, token);
    }
@GetMapping("/getProjectWithId/{projectId}")
    public Flux<ProjectWithIdResponse> getProjectWithId(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable String projectId) {
        return projectServiceImp.getProjectWithId(cloudId, token, projectId);
    }
}
