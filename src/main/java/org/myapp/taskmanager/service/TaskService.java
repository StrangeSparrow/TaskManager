package org.myapp.taskmanager.service;

import org.myapp.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task getById(int id);
}
