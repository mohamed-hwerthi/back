package com.example.back.jiraResponseDto.issues;

import com.example.back.jiraResponseDto.epics.EpicResponseJira;
import com.example.back.jiraResponseDto.sprints.SprintResponseJira;

import java.util.List;

public record AllIssuesOfSprintResponseJira(String id, String key, String description, boolean flagged, TimeTracking timeTracking, Project project, EpicResponseJira epic, long updated, SprintResponseJira sprint, List<SprintResponseJira> closedSprints, List<Comment> comments, List<Worklog> worklogs) {

}
