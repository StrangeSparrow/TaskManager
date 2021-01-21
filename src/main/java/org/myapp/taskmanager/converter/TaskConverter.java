package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<Task, TaskDto> {
    @Override
    public TaskDto convert(Task task) {
        TaskDto taskDto = TaskDto.builder().
                id(task.getId()).
                name(task.getName()).
                status(task.getStatus()).
                owner(task.getOwner() == null ? null : task.getOwner().getId()).
                executor(task.getExecutor() == null ? null : task.getExecutor().getId()).
                project(task.getProject() == null ? null : task.getProject().getId()).
                build();

        return taskDto;
    }
}
