package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;
import org.myapp.taskmanager.model.Task;

@Builder
@Data
public class TaskDto {
    private Integer id;
    private String name;
    private Task.Status status;
    private Integer owner;
    private Integer executor;
    private Integer project;
}
