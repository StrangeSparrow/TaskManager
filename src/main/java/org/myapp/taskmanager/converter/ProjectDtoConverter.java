package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter implements Converter<ProjectDto, Project> {
    @Override
    public Project convert(ProjectDto projectDto) {
        Project project = Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .build();

        return project;
    }
}
