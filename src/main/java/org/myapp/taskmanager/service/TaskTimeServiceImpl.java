package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.converter.TaskTimeConverter;
import org.myapp.taskmanager.converter.TaskTimeDtoConverter;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.model.TaskTime;
import org.myapp.taskmanager.repositories.TaskTimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskTimeServiceImpl implements TaskTimeService {
    TaskTimeRepository repository;
    TaskTimeConverter converter;
    TaskTimeDtoConverter dtoConverter;

    @Override
    public List<TaskTimeDto> getAll() {
        List<TaskTime> taskTimes = repository.findAll().stream()
                .sorted((t1, t2) -> {
                    if(t1.getDate().before(t2.getDate()))
                        return -1;
                    if(t2.getDate().before(t1.getDate()))
                        return 1;
                    return 0;
                })
                .collect(Collectors.toList());

        return convert(taskTimes);
    }

    @Override
    public TaskTimeDto getById(int id) {
        TaskTime taskTime = repository.findById(id).get();

        return converter.convert(taskTime);
    }

    @Override
    public TaskTimeDto add(TaskTimeDto taskTimeDto) {
        TaskTime taskTime = dtoConverter.convert(taskTimeDto);

        repository.save(taskTime);

        return taskTimeDto;
    }

    @Transactional
    @Override
    public TaskTimeDto update(TaskTimeDto taskTimeDto) {
        TaskTime taskTime = dtoConverter.convert(taskTimeDto);

        TaskTime fromBD = repository.getOne(taskTimeDto.getId());

        fromBD.setDate(taskTime.getDate());
        fromBD.setHours(taskTime.getHours());

        return converter.convert(fromBD);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    private List<TaskTimeDto> convert(List<TaskTime> list) {
        return list.stream().map(t -> converter.convert(t)).collect(Collectors.toList());
    }

    @Override
    public List<TaskTimeDto> getByTaskId(int id) {
        List<TaskTime> timeByTask = repository.findByTaskIdLike(id).stream()
                .sorted((t1, t2) -> {
                    if(t1.getDate().before(t2.getDate()))
                        return -1;
                    if(t2.getDate().before(t1.getDate()))
                        return 1;
                    return 0;
                })
                .collect(Collectors.toList());

        return convert(timeByTask);
    }
}
