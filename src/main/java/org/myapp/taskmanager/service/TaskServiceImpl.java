package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.converter.TaskConverter;
import org.myapp.taskmanager.converter.TaskDtoConverter;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Project;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private TaskConverter taskConverter;
    private TaskDtoConverter dtoConverter;

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
    public List<TaskDto> getByOwnerId(int id) {
        List<Task> tasks = taskRepository.findByOwnerIdLike(id);

        return convertTaskList(tasks);
    }

    @Override
    public List<TaskDto> getByExecutorId(int id) {
        List<Task> tasks = taskRepository.findByExecutorIdLike(id);

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
        task.setOwner(new User(taskDto.getOwner()));
        task.setExecutor(new User(taskDto.getExecutor()));
        task.setProject(new Project(taskDto.getProject()));

        return taskDto;
    }

    @Override
    public List<TaskDto> getByProjectId(int id) {
        List<Task> tasks = taskRepository.findByProjectIdLike(id);

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
