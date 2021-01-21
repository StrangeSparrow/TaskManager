package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter implements Converter<TaskDto, Task> {
    @Override
    public Task convert(TaskDto taskDto) {
        Task task = new Task();

        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setStatus(Task.Status.valueOf(taskDto.getStatus()));

        return task;
    }
}
