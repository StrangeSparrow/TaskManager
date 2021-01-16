package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.model.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskConverterTest {
    private static TaskConverter converter;
    private Task task;
    private TaskDto dto;

    @BeforeAll
    static void beforeAll() {
        converter = new TaskConverter();
    }

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(44);
        task.setName("TEST");
        task.setStatus(Task.Status.start);
    }

    @Test
    void convert() {
        dto = converter.convert(task);

        assertEquals(44, dto.getId());
        assertEquals("TEST", dto.getName());
        assertEquals("start", dto.getStatus());
    }
}