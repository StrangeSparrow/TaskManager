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

    @GetMapping("/by_task/{id}")
    public ProjectDto getProjectByTaskId(@PathVariable("id") int id) {
        ProjectDto project = projectService.getByTaskId(id);

        return project;
    }

    @PostMapping
    public void addProject(@RequestBody ProjectDto projectDto) {
        projectService.add(projectDto);
    }

    @PutMapping("/{id}")
    public void updateProject(@RequestBody ProjectDto projectDto) {
        projectService.update(projectDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable("id") int id) {
        projectService.deleteById(id);
    }
}
