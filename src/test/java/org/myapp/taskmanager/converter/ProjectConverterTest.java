package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.model.Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectConverterTest {
    private static ProjectConverter converter;

    @BeforeAll
    static void beforeAll() {
        converter = new ProjectConverter();
    }

    @Test
    void testConvert() {
        Project project = new Project();
        project.setId(44);
        project.setName("TEST");

        ProjectDto dto = converter.convert(project);

        assertEquals(44, dto.getId());
        assertEquals("TEST", dto.getName());
    }
}