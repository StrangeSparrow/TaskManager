package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter implements Converter<TaskDto, Task> {
    @Override
    public Task convert(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setStatus(Task.Status.start);

        return task;
    }
}
