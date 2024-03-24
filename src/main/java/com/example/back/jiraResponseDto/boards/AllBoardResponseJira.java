package com.example.back.jiraResponseDto.boards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllBoardResponseJira {
    private int maxResults;
    private int startAt;
    private int total;
    private boolean isLast;
    private List<JiraBoardResponse> values;
}
