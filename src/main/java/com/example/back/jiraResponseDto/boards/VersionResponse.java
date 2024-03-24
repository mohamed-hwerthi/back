package com.example.back.jiraResponseDto.boards;

import java.time.LocalDateTime;
import java.util.List;

public record VersionResponse(int maxResults, int startAt, int total, boolean isLast, List<Version> values) {}

record Version(String self, int id, int projectId, String name, String description, boolean archived, boolean released, LocalDateTime releaseDate) {}
