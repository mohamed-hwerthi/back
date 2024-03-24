package com.example.back.jiraResponseDto.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    private String access_token ;
    CloudIdResponse[] cloudIdResponses ;

}
