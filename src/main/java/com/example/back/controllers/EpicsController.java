package com.example.back.controllers;

import com.example.back.jiraResponseDto.epics.AllEpicsResponseJira;
import com.example.back.jiraResponseDto.epics.EpicResponseJira;
import com.example.back.serviceImp.EpicsServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/epics")
@CrossOrigin(origins = "*")
public class EpicsController {
    private final EpicsServiceImp epicsServiceImp;
    private Logger log = LoggerFactory.getLogger(EpicsController.class);

    @GetMapping("/getAllEpics/{boardId}")
    public Flux<AllEpicsResponseJira> getAllEpicsOfBoard(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int boardId) {
        log.info("controller get All epics is matchning ");
        return epicsServiceImp.getAllEpicsOfBoard(cloudId, token, boardId);
    }

    @GetMapping("/getEpicWithId/{epicId}")
    public Flux<EpicResponseJira> getEpicWithId(@RequestHeader("cloudId") String cloudId,
            @RequestHeader("token") String token, @PathVariable int epicId) {
        log.info("getEpicWithId is  working well");
        return epicsServiceImp.getEpicWithId(cloudId, token, epicId);
    }
}
