package com.example.back.jiraResponseDto.issues;

import java.util.List;

public record AllIssueResponseJira (int startAt,int maxResults, int total, List<IssueResponseJira> issues){
}
