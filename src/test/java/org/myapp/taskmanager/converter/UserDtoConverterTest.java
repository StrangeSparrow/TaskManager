package org.myapp.taskmanager.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDtoConverterTest {
    private static UserDtoConverter converter;
    private User user;
    private UserDto dto;

    @BeforeAll
    static void beforeAll() {
        converter = new UserDtoConverter();
    }

    @BeforeEach
    void setUp() {
        dto = UserDto.builder().id(44).name("TEST").role(User.Role.ADMIN).build();
    }

    @Test
    void convert() {
        user = converter.convert(dto);

        assertEquals(44, user.getId());
        assertEquals("TEST", user.getName());
        assertEquals(User.Role.ADMIN, user.getRole());
    }
}