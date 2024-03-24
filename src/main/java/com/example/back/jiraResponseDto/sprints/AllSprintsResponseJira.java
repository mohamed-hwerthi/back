package com.example.back.jiraResponseDto.sprints;

import java.util.List;

public record AllSprintsResponseJira(int maxResults, int startAt, int total, boolean isLast, List<SprintResponseJira> values) {
}
