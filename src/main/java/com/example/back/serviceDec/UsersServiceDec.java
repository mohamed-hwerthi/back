package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.users.UsersReponseJira;
import reactor.core.publisher.Flux;

public interface UsersServiceDec {
    //get default users
    Flux<UsersReponseJira>getAllUsers(String cloudId , String token) ;

}
