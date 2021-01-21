package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskTimeDto;

import java.util.List;

public interface TaskTimeService {
    List<TaskTimeDto> getAll();

    TaskTimeDto getById(int id);

    TaskTimeDto add(TaskTimeDto taskTimeDto);

    TaskTimeDto update(TaskTimeDto taskTimeDto);

    void deleteById(int id);
}
