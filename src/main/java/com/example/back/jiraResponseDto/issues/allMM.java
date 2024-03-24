package com.example.back.jiraResponseDto.issues;

import java.util.List;

public record allMM(int startAt, int maxResults, int total, List<AllIssuesOfSprintResponseJira> issues) {
}
