package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ProjectDto {
    private int id;
    private String name;
}
