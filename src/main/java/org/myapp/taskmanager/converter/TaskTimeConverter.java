package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.AppConst;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.model.TaskTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TaskTimeConverter implements Converter<TaskTime, TaskTimeDto> {
    @Override
    public TaskTimeDto convert(TaskTime taskTime) {
        SimpleDateFormat format = new SimpleDateFormat(AppConst.DATA_FORMAT);

        String dataString = format.format(taskTime.getDate());

        TaskTimeDto taskTimeDto = TaskTimeDto.builder()
                .id(taskTime.getId())
                .hours(taskTime.getHours())
                .data(dataString)
                .user(taskTime.getUser().getId())
                .task(taskTime.getTask().getId())
                .build();

        return taskTimeDto;
    }
}
