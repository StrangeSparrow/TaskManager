package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter implements Converter<ProjectDto, Project> {
    @Override
    public Project convert(ProjectDto projectDto) {
        Project project = new Project();

        if (projectDto.getId() != 0)
            project.setId(projectDto.getId());
        else
            project.setId(null);

        project.setName(projectDto.getName());

        return project;
    }
}
