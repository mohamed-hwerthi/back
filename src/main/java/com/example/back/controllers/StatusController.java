package com.example.back.controllers;
import com.example.back.jiraResponseDto.Status.StatusResponseJira;
import com.example.back.jiraResponseDto.Status.StatusSearchResJira;
import com.example.back.serviceImp.StatusServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StatusController {
    private  final StatusServiceImp serviceImp ;

    @GetMapping("/all")

    public Flux<StatusResponseJira> getAllStatus(@RequestHeader("cloudId")  String cloudId, @RequestHeader("token")  String token) {
        return serviceImp.getAllStatus(cloudId, token);
    }
    @GetMapping("/getStatusesForProject/{projectId}")
    public Flux<StatusSearchResJira> getBoardStatusJira ( @RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable String projectId) {
        return serviceImp.getBoardStatusJira(cloudId, token, projectId);
    }
}
