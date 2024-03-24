package com.example.back.jiraResponseDto.sprints;

public record SprintResponseJira(int id, String self, String state, String name, String startDate, String endDate, String completeDate, int originBoardId) {
}
