package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskDto {
    private final int id;
    private final String name;
    private final String status;
}
