package com.example.back.jiraResponseDto.projects;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProjectWithIdResponse {
    private String expand;
    private String self;
    private String id;
    private String key;
    private String description;
    private User lead;
    private List<IssueType> issueTypes;
    private String assigneeType;
    private List<Object> versions;
    private String name;
    private Map<String, String> roles;
    private AvatarUrls avatarUrls;
    private String projectTypeKey;
    private boolean simplified;
    private String style;
    private boolean isPrivate;
    private Map<String, Object> properties;
    private String entityId;
    private String uuid;

    // Getters and setters
}
@Data
class User {
    private String self;
    private String accountId;
    private AvatarUrls avatarUrls;
    private String displayName;
    private boolean active;

    // Getters and setters
}

@Data
class IssueType {
    private String self;
    private String id;
    private String description;
    private String iconUrl;
    private String name;
    private boolean subtask;
    private String avatarId;
    private int hierarchyLevel;

    // Getters and setters
}
@Data
class AvatarUrls {
    private String _48x48;
    private String _24x24;
    private String _16x16;
    private String _32x32;

    // Getters and setters
}