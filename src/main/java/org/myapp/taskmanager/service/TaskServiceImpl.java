package org.myapp.taskmanager.service;

import org.myapp.taskmanager.converter.TaskConverter;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskConverter taskConverter;

    @Override
    public List<TaskDto> getAll() {
        List<Task> tasks = taskRepository.findAll();

        return convertTaskList(tasks);
    }

    @Override
    public TaskDto getById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        TaskDto taskDto = taskConverter.convert(task.get());

        return taskDto;
    }

    private List<TaskDto> convertTaskList(List<Task> tasks) {
        List<TaskDto> taskDtoList = new ArrayList<>();

        for (Task task : tasks) {
            taskDtoList.add(taskConverter.convert(task));
        }
        return taskDtoList;
    }
}
