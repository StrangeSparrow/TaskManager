package org.myapp.taskmanager.service;

import org.myapp.taskmanager.converter.ProjectConverter;
import org.myapp.taskmanager.converter.ProjectDtoConverter;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;
import org.myapp.taskmanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectConverter projectConverter;
    @Autowired
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
        Project project = projectRepository.findProjectsByTaskId(id);

        return projectConverter.convert(project);
    }

    @Override
    public ProjectDto add(ProjectDto projectDto) {
        Project project = dtoConverter.convert(projectDto);

        projectRepository.save(project);

        return projectDto;
    }

    @Override
    public ProjectDto update(ProjectDto projectDto, int id) {
        Project project = projectRepository.findById(id).get();

        project.setName(projectDto.getName());

        projectRepository.flush();

        return projectDto;
    }

    @Override
    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }

    private List<ProjectDto> convertProjectList(List<Project> projects) {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (Project project : projects) {
            projectDtoList.add(projectConverter.convert(project));
        }
        return projectDtoList;
    }
}
