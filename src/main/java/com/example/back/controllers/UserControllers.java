package com.example.back.controllers;
import com.example.back.jiraResponseDto.users.UsersReponseJira;
import com.example.back.serviceImp.UsersServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserControllers {
    private  final UsersServiceImp usersServiceImp ;
    private  final Logger log = LoggerFactory.getLogger(UserControllers.class) ;



    @GetMapping("/getAll")
    public Flux<UsersReponseJira> getAllUsers(@RequestHeader("cloudId") String cloudId,@RequestHeader("token") String token) {
        return usersServiceImp.getAllUsers(cloudId, token);
    }
}
