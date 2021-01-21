package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskDto {
    private Integer id;
    private String name;
    private String status;
    private Integer owner;
    private Integer executor;
    private Integer project;
}
