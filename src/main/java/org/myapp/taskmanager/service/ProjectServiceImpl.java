package org.myapp.taskmanager.service;

import org.myapp.taskmanager.converter.ProjectConverter;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Project;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectConverter projectConverter;

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

    private List<ProjectDto> convertProjectList(List<Project> projects) {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (Project project : projects) {
            projectDtoList.add(projectConverter.convert(project));
        }
        return projectDtoList;
    }
}
