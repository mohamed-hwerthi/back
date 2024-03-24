package com.example.back.jiraResponseDto.permissionsSchema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;



@Data
public class AllpermissionsSchema{
    List<PermissionScheme>permissionSchemes ;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class PermissionScheme {
    private String expand;
    private long id;
    private String self;
    private String name;
    private List<Permission> permissions;
}


@Data
    class Permission {
        private long id;
        private String self;
        private Holder holder;
        private String permission;


    }
    @Data
     class Holder {
        private String type;
        private String parameter;
        private String value;
        private String expand;


    }


