package com.example.back.jiraResponseDto.issues;

public record TimeTracking(    String originalEstimate, String remainingEstimate, String timeSpent, int originalEstimateSeconds, int remainingEstimateSeconds, int timeSpentSeconds) {
}
