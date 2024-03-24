package com.example.back.jiraResponseDto.epics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

 public record Color(String key) { }