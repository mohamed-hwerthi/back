package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.roles.RolesDetailsOfProject;
import com.example.back.jiraResponseDto.roles.RolesResponseJira;
import reactor.core.publisher.Flux;

public interface RolesServicesDec {
    //get roles of all projects  :
Flux<RolesResponseJira>getAllRolesOfAllProjects(String cloudId  , String token ) ;
    //get roles details  of one project  :
    Flux<RolesDetailsOfProject>getAllRolesDetailsOfProject(String cloudId , String token , String projectId)  ;

    //getting roles by id   :




}
