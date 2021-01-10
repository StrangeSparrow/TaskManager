package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<Task, TaskDto> {
    @Override
    public TaskDto convert(Task task) {
        TaskDto taskDto;
        taskDto = TaskDto.builder().
                id(task.getId()).
                name(task.getName()).
                status(task.getStatus().name()).
                build();

        return taskDto;
    }
}
