package org.myapp.taskmanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;
import org.myapp.taskmanager.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    private List<User> listTestData;
    @MockBean
    private UserRepositories userRepositories;
    @Autowired
    private UserServiceImpl service;

    @BeforeEach
    void setUp() {
        listTestData = new ArrayList<>();
        listTestData.add(new User(1, "test1", "test1", User.Role.admin, null, null, null, null));
        listTestData.add(new User(2, "test2", "test2", User.Role.executor, null, null, null, null));
        listTestData.add(new User(3, "test3", "test3", User.Role.executor, null, null, null, null));
        listTestData.add(new User(4, "test4", "test4", User.Role.manager, null, null, null, null));
    }

    @Test
    void getAll() {
        when(userRepositories.findAll()).thenReturn(listTestData);

        List<UserDto> users = service.getAll();

        assertEquals(4, users.size());
        assertEquals("test2", users.get(1).getName());
    }

    @Test
    void getById() {
        given(userRepositories.findById(3)).willReturn(Optional.of(listTestData.get(2)));

        UserDto user = service.getById(3);

        assertEquals(3, user.getId());
        assertEquals("test3", user.getName());
    }

    @Test
    void deleteUserById() {
        service.deleteUserById(1);

        Mockito.verify(userRepositories, atLeastOnce()).deleteById(1);
    }

    @Test
    void getUsersByOwnerTaskId() {
        when(userRepositories.findByOwnerTasksIdLike(1)).thenReturn(new User(1, "test4", "test4", User.Role.manager, null, null, null, null));

        service.getUsersByOwnerTaskId(1);

        Mockito.verify(userRepositories, atLeastOnce()).findByOwnerTasksIdLike(1);
    }

    @Test
    void getUsersByExecutorTaskId() {
        when(userRepositories.findByExecutorTasksIdLike(1)).thenReturn(new User(1, "test4", "test4", User.Role.manager, null, null, null, null));

        service.getUsersByExecutorTaskId(1);

        Mockito.verify(userRepositories, atLeastOnce()).findByExecutorTasksIdLike(1);
    }
}