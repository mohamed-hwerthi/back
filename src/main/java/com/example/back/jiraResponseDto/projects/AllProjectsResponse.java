package com.example.back.jiraResponseDto.projects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
 public class AllProjectsResponse {
   private String expand;
   private String self;
   private String id;
   private String key;
   private String name;
   private Map<String, String> avatarUrls;
   private String projectTypeKey;
   private boolean simplified;
   private String style;
   private boolean isPrivate;
   private Map<String, Object> properties;
   private String entityId;
   private String uuid;
}
