package com.example.back.jiraResponseDto.issues;

public record Author(
        String name,
        String displayName,
        boolean active
) {}