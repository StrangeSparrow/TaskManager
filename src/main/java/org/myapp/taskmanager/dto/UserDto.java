package org.myapp.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class UserDto {
    private final int id;
    private final String name;
    private final String role;
}
