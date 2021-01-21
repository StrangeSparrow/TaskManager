package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskDtoConverterTest {
    private static TaskDtoConverter converter;
    private Task task;
    private TaskDto dto;

    @BeforeAll
    static void beforeAll() {
        converter = new TaskDtoConverter();
    }

    @BeforeEach
    void setUp() {
        dto = TaskDto.builder().id(44).name("TEST").status(Task.Status.start).build();
    }

    @Test
    void convert() {
        task = converter.convert(dto);

        assertEquals(44, task.getId());
        assertEquals("TEST", task.getName());
        assertEquals("finish", task.getStatus().name());
    }
}