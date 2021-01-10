package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.converter.TaskConverter;
import org.myapp.taskmanager.converter.TaskDtoConverter;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Project;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.repositories.ProjectRepository;
import org.myapp.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;
    TaskConverter taskConverter;
    TaskDtoConverter dtoConverter;
    ProjectRepository projectRepository;

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

    @Override
    public List<TaskDto> getByUserId(int id) {
        List<Task> tasks = taskRepository.findTasksByUserId(id);

        return convertTaskList(tasks);
    }

    @Override
    public TaskDto add(TaskDto taskDto) {
        Task task = dtoConverter.convert(taskDto);

        taskRepository.save(task);

        return taskDto;
    }

    @Transactional
    @Override
    public TaskDto update(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getId()).get();

        task.setName(taskDto.getName());
        task.setStatus(Task.Status.valueOf(taskDto.getStatus()));

        return taskDto;
    }

    @Override
    public List<TaskDto> getByProjectId(int id) {
        Project project = projectRepository.findById(id).get();

        List<Task> tasks = project.getTasks();

        return convertTaskList(tasks);
    }

    @Override
    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    private List<TaskDto> convertTaskList(List<Task> tasks) {
        return tasks.stream().map(task -> taskConverter.convert(task)).collect(Collectors.toList());
    }
}
