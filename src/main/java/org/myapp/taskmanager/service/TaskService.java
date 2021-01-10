package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAll();

    TaskDto getById(int id);

    TaskDto add(TaskDto task);

    List<TaskDto> getByUserId(int id);

    TaskDto update(TaskDto task, int id);

    void delete(int id);
}
