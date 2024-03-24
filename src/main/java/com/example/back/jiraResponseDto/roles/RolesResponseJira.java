package com.example.back.jiraResponseDto.roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesResponseJira {
    private String self  ;
    private  String name  ;
    private  int id   ;
    private  String description ;

}
