package com.example.back.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;


@Configuration
    public class BeansConfig {

        @Bean
        public WebClient webClient(){
            final int size = 16 * 1024 * 1024;
            final ExchangeStrategies strategies = ExchangeStrategies.builder()
                    .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                    .build();
            WebClient webClient = WebClient
                    .builder()
                    .exchangeStrategies(strategies)
                    .baseUrl("https://api.atlassian.com/ex/jira/")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE , MediaType.APPLICATION_JSON_VALUE)
                    .defaultHeader(HttpHeaders.ACCEPT , MediaType.APPLICATION_JSON_VALUE)
                    .build() ;
            return webClient;
        }
        @Bean
        public ObjectMapper objectMapper(){
            ObjectMapper objectMapper = new ObjectMapper() ;
            return  objectMapper ;
        }


    }

