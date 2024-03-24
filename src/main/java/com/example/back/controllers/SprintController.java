package com.example.back.controllers;

import com.example.back.jiraResponseDto.sprints.AllSprintsResponseJira;
import com.example.back.jiraResponseDto.sprints.SprintResponseJira;
import com.example.back.serviceImp.SprintServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sprints")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SprintController {
    private final SprintServiceImp serviceImp;
    private final Logger log = LoggerFactory.getLogger(SprintController.class);

    @GetMapping("/getAllSprintsOfBoard/{boardId}")

    public Flux<AllSprintsResponseJira> getAllSprints(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int boardId) {
        return serviceImp.getAllSprints(cloudId, token, boardId);
    }

    @GetMapping("/getSprintWithId/{sprintId}")
    public Flux<SprintResponseJira> getSprintWithId(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int sprintId) {
        return serviceImp.getSprintWithId(cloudId, token, sprintId);
    }

}
