package com.example.back.jiraResponseDto.roles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesDetailsOfProject {
    private  String self  ;
    private  String name  ;
    private  int id  ;
    private  String description ;
    private  boolean admin  ;
    private  boolean isDefaut ;
    private boolean roleConfigurable;
    private String translatedName;


}
