package com.example.back.controllers;
import com.example.back.jiraResponseDto.priority.JiraPriorityResponse;
import com.example.back.serviceImp.PriorityServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/priorities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PriorityControllers {
private  final PriorityServiceImp priorityServiceImp ;


@GetMapping("/all")
    public Flux<JiraPriorityResponse> getAllpriorities(@RequestHeader("cloudId") String cloudId  , @RequestHeader("token") String token) {
        return priorityServiceImp.getAllpriorities(cloudId, token);
    }
}
