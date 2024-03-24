package com.example.back.jiraResponseDto.issues;

public record Worklog(
        Author author,
        String comment,
        Visibility visibility,
        String started,
        String timeSpent,
        int timeSpentSeconds,
        String id
) {}