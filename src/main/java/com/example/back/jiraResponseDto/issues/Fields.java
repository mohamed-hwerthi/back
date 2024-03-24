package com.example.back.jiraResponseDto.issues;

import com.example.back.jiraResponseDto.epics.EpicResponseJira;

public record Fields(TimeTracking timetracking, Project project, EpicResponseJira epic) {
}
