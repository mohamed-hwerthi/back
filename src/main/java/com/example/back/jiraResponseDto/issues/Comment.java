package com.example.back.jiraResponseDto.issues;

public record Comment(   String id, Author author, String body, String created, String updated, Visibility visibility) {
}
