package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.converter.ProjectConverter;
import org.myapp.taskmanager.converter.ProjectDtoConverter;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;
import org.myapp.taskmanager.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    ProjectConverter projectConverter;
    ProjectDtoConverter dtoConverter;

    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = projectRepository.findAll();

        return convertProjectList(projects);
    }

    @Override
    public ProjectDto getById(int id) {
        Optional<Project> project = projectRepository.findById(id);

        return projectConverter.convert(project.get());
    }

    @Override
    public ProjectDto getByTaskId(int id) {
        Project project = projectRepository.findByTasksIdLike(id);

        if (project == null)
            return ProjectDto.builder().build();

        return projectConverter.convert(project);
    }

    @Override
    public ProjectDto add(ProjectDto projectDto) {
        Project project = dtoConverter.convert(projectDto);

        projectRepository.save(project);

        return projectDto;
    }

    @Transactional
    @Override
    public ProjectDto update(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getId()).get();

        project.setName(projectDto.getName());

        return projectDto;
    }

    @Override
    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }

    private List<ProjectDto> convertProjectList(List<Project> projects) {
        return projects.stream().map(project -> projectConverter.convert(project)).collect(Collectors.toList());
    }
}
