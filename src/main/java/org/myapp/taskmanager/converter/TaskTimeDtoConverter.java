package org.myapp.taskmanager.converter;

import lombok.SneakyThrows;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.model.Task;
import org.myapp.taskmanager.model.TaskTime;
import org.myapp.taskmanager.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TaskTimeDtoConverter implements Converter<TaskTimeDto, TaskTime> {
    @SneakyThrows
    @Override
    public TaskTime convert(TaskTimeDto taskTimeDto) {
        SimpleDateFormat format = new SimpleDateFormat();

        TaskTime taskTime = new TaskTime();

        taskTime.setId(taskTimeDto.getId());
        taskTime.setHours(taskTimeDto.getHours());
        taskTime.setDate(format.parse(taskTimeDto.getData()));

        if(taskTimeDto.getUser() != 0)
            taskTime.setUser(new User(taskTimeDto.getUser()));

        if(taskTimeDto.getTask() != 0)
            taskTime.setTask(new Task(taskTimeDto.getTask()));

        return taskTime;
    }
}
