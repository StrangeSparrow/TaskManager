package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAll();

    TaskDto getById(int id);

    TaskDto add(TaskDto task);

    List<TaskDto> getByOwnerId(int id);

    List<TaskDto> getByExecutorId(int id);

    TaskDto update(TaskDto task);

    List<TaskDto> getByProjectId(int id);

    void delete(int id);
}
