package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.priority.JiraPriorityResponse;
import reactor.core.publisher.Flux;

import javax.swing.*;

public interface PriorityServiceDec {
    //get all priorities  :
    Flux<JiraPriorityResponse>getAllpriorities(String cloudId , String token) ;


}
