package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.auth.AccessTokenResponse;
import com.example.back.models.AuthModel;
import com.example.back.jiraResponseDto.auth.AuthResponseDto;
import com.example.back.jiraResponseDto.auth.CloudIdResponse;
import com.example.back.serviceDec.authServiceDec;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class authServiceImp implements authServiceDec {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final Logger log  = LoggerFactory.getLogger(authServiceImp.class) ;
    @Override
    public ResponseEntity<?> getOauthData(String clientID, String secretId, String oauthCode) {
        AuthModel authModel = new AuthModel(clientID, secretId, oauthCode);
        AuthResponseDto authResponse = new AuthResponseDto() ;
        try {
            String accesToken = getAccessTokenFromJira(authModel);
            authResponse.setAccess_token(accesToken);
            log.info(accesToken);
            CloudIdResponse[] cloudIdResponses = getCloudIdFromJira(accesToken);
            authResponse.setCloudIdResponses(cloudIdResponses) ;

            String jsonString = objectMapper.writeValueAsString(authResponse);
            return ResponseEntity.status(HttpStatus.OK).body(jsonString);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("can not get Access Token from jira ");

        }

    }
    @Override
    public String getAccessTokenFromJira(AuthModel authModel) {
        WebClient.ResponseSpec responseSpec = webClient.post()
                .uri("https://auth.atlassian.com/oauth/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue("{\"grant_type\": \"authorization_code\",\"client_id\": \"" + authModel.client_id + "\",\"client_secret\": \"" + authModel.getClient_secret() + "\",\"code\": \"" + authModel.getCode() + "\",\"redirect_uri\": \"http://localhost:4200/auth2\"}"))
                .retrieve();
        String response = responseSpec.bodyToMono(String.class).block();
        log.info(response);
        try {
            AccessTokenResponse convertedResponse = objectMapper.readValue(response, AccessTokenResponse.class);
            return convertedResponse.getAccess_token();

        } catch (Exception e) {
            e.printStackTrace();
            return "can not convert AccesTokenResponse to java Object ";
        }


    }

    @Override
    public CloudIdResponse[] getCloudIdFromJira(String accessToken) {
        String authorisation = "Bearer " + accessToken;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Authorization", authorisation);
        WebClient.ResponseSpec responseSpec = webClient
                .get()
                .uri("https://api.atlassian.com/oauth/token/accessible-resources")
                .headers(h -> h.addAll(headers))
                .retrieve();
        String response = responseSpec.bodyToMono(String.class).block();
        try {
            CloudIdResponse[] cloudIdResponse = objectMapper.readValue(response, CloudIdResponse[].class);
           return  cloudIdResponse ;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Exception in converting cloudIdRespnse json to java") ;


        }

    }


}