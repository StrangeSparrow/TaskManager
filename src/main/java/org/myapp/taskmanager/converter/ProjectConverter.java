package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter implements Converter<Project, ProjectDto> {
    @Override
    public ProjectDto convert(Project project) {
        ProjectDto projectDto = ProjectDto.builder().id(project.getId()).name(project.getName()).build();

        return projectDto;
    }
}
