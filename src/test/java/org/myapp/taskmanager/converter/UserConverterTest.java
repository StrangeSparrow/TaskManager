package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserConverterTest {
    private static UserConverter converter;
    private User user;
    private UserDto dto;

    @BeforeAll
    static void beforeAll() {
        converter = new UserConverter();
    }

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(44);
        user.setName("TEST");
        user.setRole(User.Role.admin);
    }

    @Test
    void convert() {
        dto = converter.convert(user);

        assertEquals(44, dto.getId());
        assertEquals("TEST", dto.getName());
        assertEquals("admin", dto.getRole());
    }
}