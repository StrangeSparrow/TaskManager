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
        TaskTime taskTime = TaskTime.builder()
                .id(taskTimeDto.getId())
                .hours(taskTimeDto.getHours())
                .date(SimpleDateFormat.getDateInstance()
                        .parse(taskTimeDto.getData()))
                .build();

        if(taskTimeDto.getUser() != 0)
            taskTime.setUser(new User(taskTimeDto.getUser()));

        if(taskTimeDto.getTask() != 0)
            taskTime.setTask(new Task(taskTimeDto.getTask()));

        return taskTime;
    }
}
