package org.myapp.taskmanager.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {
    @MockBean
    private ProjectService service;
    @Autowired
    private MockMvc controller;

    @Test
    void getAllProjects() throws Exception {
        when(service.getAll()).thenReturn(new ArrayList<ProjectDto>());

        controller.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getProjectById() throws Exception {
        when(service.getById(1)).thenReturn(ProjectDto.builder().id(1).name("test").build());

        controller.perform(get("/projects/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"test\"}"
                ));
    }

    @Test
    void getProjectByTaskId() throws Exception {
        controller.perform(get("/projects/by-task/1"))
                .andExpect(status().isOk());

        Mockito.verify(service, atLeastOnce()).getByTaskId(1);
    }

    @Test
    void addProject() throws Exception {
        controller.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"test\"}"));

        verify(service).add(any());
    }

    @Test
    void updateProject() throws Exception {
        controller.perform(put("/projects/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"test\"}"));

        verify(service).update(any());
    }

    @Test
    void deleteProjectById() throws Exception {
        controller.perform(delete("/projects/1"))
                .andExpect(status().isOk());

        verify(service).deleteById(1);
    }
}