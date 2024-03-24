package com.example.back.serviceDec;

import com.example.back.models.AuthModel;
import com.example.back.jiraResponseDto.auth.CloudIdResponse;
import org.springframework.http.ResponseEntity;

public interface authServiceDec {

   ResponseEntity<?> getOauthData(String clientId , String secretId, String oauthCode) ;
    String getAccessTokenFromJira(AuthModel authModel) ;
   CloudIdResponse[] getCloudIdFromJira(String accessToken) ;



}
