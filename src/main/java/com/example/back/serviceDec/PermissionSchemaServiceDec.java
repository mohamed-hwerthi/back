package com.example.back.serviceDec;
import com.example.back.jiraResponseDto.permissionsSchema.AllpermissionsSchema;
import com.example.back.jiraResponseDto.permissionsSchema.ProjectPermissionSchema;
import reactor.core.publisher.Flux;

public interface PermissionSchemaServiceDec {
    Flux<AllpermissionsSchema> getAllPermissions(String cloudId , String token) ;
    Flux<ProjectPermissionSchema>getProjectPermissionSchema(String cloudId  , String token  , String projectId) ;



}
