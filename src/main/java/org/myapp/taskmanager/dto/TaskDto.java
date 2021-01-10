package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskDto {
    private int id;
    private String name;
    private String status;
}
