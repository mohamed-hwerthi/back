package com.example.back.jiraResponseDto.boards;

import java.util.List;

record Column(String name, List<Status> statuses, Integer min, Integer max) {}
