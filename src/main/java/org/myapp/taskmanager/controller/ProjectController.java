package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        List<ProjectDto> projects = projectService.getAll();

        return projects;
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable("id") int id) {
        ProjectDto project = projectService.getById(id);

        return project;
    }
}
