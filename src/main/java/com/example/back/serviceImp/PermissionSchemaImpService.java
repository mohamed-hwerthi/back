package com.example.back.serviceImp;
import com.example.back.jiraResponseDto.permissionsSchema.AllpermissionsSchema;
import com.example.back.jiraResponseDto.permissionsSchema.ProjectPermissionSchema;
import com.example.back.serviceDec.PermissionSchemaServiceDec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;



@Service
@RequiredArgsConstructor
public class PermissionSchemaImpService implements PermissionSchemaServiceDec {
    private final WebClient webClient;

    @Override
    public Flux<AllpermissionsSchema> getAllPermissions(String cloudId, String token) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/permissionscheme")
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(AllpermissionsSchema.class);

    }

    @Override
    public Flux<ProjectPermissionSchema> getProjectPermissionSchema(String cloudId, String token, String projectId) {
        String authorisation = "Bearer " + token;
        return webClient.get()
                .uri(cloudId + "/rest/api/3/permissionscheme/"+projectId)
                .header("Accept", "application/json")
                .header("Authorization", authorisation)
                .retrieve()
                .bodyToFlux(ProjectPermissionSchema.class);
    }
}

