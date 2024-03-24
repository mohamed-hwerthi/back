package com.example.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BackApplication {
	private final Logger logger = LoggerFactory.getLogger(BackApplication.class);

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

	@PostConstruct()
	public void postContruct() {
		logger.info("pfe spring boot backend is working on port" + port);

	}

}
