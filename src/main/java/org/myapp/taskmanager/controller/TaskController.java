package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        List<TaskDto> tasks = taskService.getAll();
        return tasks;
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable("id") int id) {
        TaskDto task = taskService.getById(id);
        return task;
    }

    @GetMapping("/by_user/{id}")
    public List<TaskDto> getTasksByUserId(@PathVariable("id") int id) {
        List<TaskDto> tasks = taskService.getByUserId(id);
        return tasks;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.delete(id);
    }

    @PostMapping
    public void addTask(@RequestBody TaskDto task) {
        taskService.add(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable("id") int id, @RequestBody TaskDto task) {
        taskService.update(task, id);
    }
}
