

package com.example.back.jiraResponseDto.epics;

import com.example.back.jiraResponseDto.epics.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record   EpicResponseJira(int id  , String self , String name  , String summary , Color color , boolean done ) {

}

