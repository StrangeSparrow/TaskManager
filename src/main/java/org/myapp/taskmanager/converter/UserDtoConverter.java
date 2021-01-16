package org.myapp.taskmanager.converter;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setRole(User.Role.valueOf(userDto.getRole()));

        return user;
    }
}
