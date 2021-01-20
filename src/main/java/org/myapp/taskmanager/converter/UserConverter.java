package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .role(user.getRole().name())
                .build();

        return userDto;
    }
}
