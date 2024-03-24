package com.example.back.jiraResponseDto.auth;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccessTokenResponse {
    String access_token ;
    int expires_in= 3600 ;
    String token_type ;
    String scope   ;
}
