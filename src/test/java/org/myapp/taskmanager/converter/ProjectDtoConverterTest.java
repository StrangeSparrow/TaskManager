package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectDtoConverterTest {
    private static ProjectDtoConverter converter;
    private Project project;
    private ProjectDto dto;

    @BeforeAll
    static void beforeAll() {
        converter = new ProjectDtoConverter();
    }

    @BeforeEach
    void setUp() {
        dto = ProjectDto.builder().id(33).name("TEST").build();
    }

    @Test
    void convert() {
        project = converter.convert(dto);

        assertEquals(33, project.getId());
        assertEquals("TEST", project.getName());
    }
}