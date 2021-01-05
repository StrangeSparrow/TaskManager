package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAll();
    TaskDto getById(int id);
}
