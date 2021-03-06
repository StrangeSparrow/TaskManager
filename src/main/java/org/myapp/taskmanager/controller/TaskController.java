package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {
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

    @GetMapping("/by-owner/{id}")
    public List<TaskDto> getTasksByOwnerId(@PathVariable("id") int id) {
        List<TaskDto> tasks = taskService.getByOwnerId(id);
        return tasks;
    }

    @GetMapping("/by-executor/{id}")
    public List<TaskDto> getTasksByExecutorId(@PathVariable("id") int id) {
        List<TaskDto> tasks = taskService.getByExecutorId(id);
        return tasks;
    }

    @GetMapping("/by-project/{id}")
    public List<TaskDto> getTasksByProjectId(@PathVariable("id") int id) {
        List<TaskDto> tasks = taskService.getByProjectId(id);

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

    @PutMapping
    public void updateTask(@RequestBody TaskDto task) {
        taskService.update(task);
    }
}
