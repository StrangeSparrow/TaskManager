package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}/delete")
    public void deleteProjectById(@PathVariable("id") int id) {
        projectService.deleteById(id);
    }
}
