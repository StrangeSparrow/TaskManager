package org.myapp.taskmanager.service;

import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    @Override
    public Task getById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }
}
