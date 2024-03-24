package com.example.back.controllers;
import com.example.back.jiraResponseDto.roles.RolesDetailsOfProject;
import com.example.back.jiraResponseDto.roles.RolesResponseJira;
import com.example.back.serviceImp.RolesServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@CrossOrigin(origins = "*")

public class RolesControllers {
    private  final RolesServiceImp rolesServiceImp ;

    @GetMapping("rolesOfOneProject/{projectId}")
    public Flux<RolesDetailsOfProject> getAllRolesDetailsOfProject(  @RequestHeader("cloudId") String cloudId,@RequestHeader("token") String token,@PathVariable String projectId) {
        return rolesServiceImp.getAllRolesDetailsOfProject(cloudId, token, projectId);
    }

    @GetMapping("/getAllRolesOfAllProjects")
    public Flux<RolesResponseJira> getAllRolesOfAllProjects(@RequestHeader("cloudId") String cloudId,@RequestHeader("token") String token) {
        return rolesServiceImp.getAllRolesOfAllProjects(cloudId, token);
    }
}
