package com.example.back.jiraResponseDto.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersReponseJira {
    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("avatarUrls")
    private AvatarUrls avatarUrls;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("self")
    private String self;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class AvatarUrls {
    @JsonProperty("16x16")
    private String size16;

    @JsonProperty("24x24")
    private String size24;

    @JsonProperty("32x32")
    private String size32;

    @JsonProperty("48x48")
    private String size48;

    // Getters and setters
}
