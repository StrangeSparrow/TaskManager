package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAll();

    ProjectDto getById(int id);

    void deleteById(int id);
}