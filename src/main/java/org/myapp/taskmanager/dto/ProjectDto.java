package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDto {
    private Integer id;
    private String name;
}
