package com.example.back.controllers;


import com.example.back.jiraResponseDto.permissionsSchema.AllpermissionsSchema;

import com.example.back.jiraResponseDto.permissionsSchema.ProjectPermissionSchema;
import com.example.back.serviceImp.PermissionSchemaImpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permissionSchema")
public class PermissionSchemaController {
    private  final PermissionSchemaImpService permissionSchemaService  ;
@GetMapping("/all")
    public Flux<AllpermissionsSchema> getAllPermissions(String cloudId, String token) {
        return permissionSchemaService.getAllPermissions(cloudId, token);
    }
    @GetMapping("permissionsSchemaOfProject/{projectId}")
    public Flux<ProjectPermissionSchema> getProjectPermissionSchema(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable() String projectId) {
        return permissionSchemaService.getProjectPermissionSchema(cloudId, token, projectId);
    }
}
