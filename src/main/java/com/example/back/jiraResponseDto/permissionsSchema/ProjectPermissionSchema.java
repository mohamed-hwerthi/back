package com.example.back.jiraResponseDto.permissionsSchema;
import lombok.Data;
import java.util.List;
@Data
public class ProjectPermissionSchema {
    private String expand;
    private long id;
    private String self;
    private String name;
    private Scope scope;
    private List<Permission> permissions;
}
@Data
 class Scope {
    private String type;
    private Project project;

    // Getters and setters
}
@Data
class Project {
    private String id;

    // Getters and setters
}
