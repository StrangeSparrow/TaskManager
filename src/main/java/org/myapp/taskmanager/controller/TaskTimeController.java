package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.service.TaskTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/time")
public class TaskTimeController {
    TaskTimeService service;

    @GetMapping
    public List<TaskTimeDto> getAll() {
        List<TaskTimeDto> taskTime = service.getAll();

        return taskTime;
    }

    @GetMapping("/{id}")
    public TaskTimeDto getById(@PathVariable("id") int id) {
        TaskTimeDto taskTime = service.getById(id);

        return taskTime;
    }

    @GetMapping("/by-task/{id}")
    public List<TaskTimeDto> getByTaskId(@PathVariable("id") int id) {
        List<TaskTimeDto> time = service.getByTaskId(id);

        return time;
    }

    @PostMapping
    public void addTimeForTask(@RequestBody TaskTimeDto time) {
        service.add(time);
    }
}
