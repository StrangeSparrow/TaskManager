package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        List<Task> tasks = taskService.getAll();
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id) {
        Task task = taskService.getById(id);
        return task;
    }
}
