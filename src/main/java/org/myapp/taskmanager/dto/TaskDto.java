package org.myapp.taskmanager.dto;

import lombok.Data;

@Data
public class TaskDto {
    private int id;
    private String name;
    private UserDto owner;
    private UserDto executor;
    private String status;
    private ProjectDto project;
}
