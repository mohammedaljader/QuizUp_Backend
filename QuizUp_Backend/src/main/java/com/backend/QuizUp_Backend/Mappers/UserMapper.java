package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserMapper implements IUserMapper{

    @Override
    public List<UserDto> convertEntityToDto(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user: users) {
            List<String> helpOptions = user.getHelpOptionsList().stream().map(Enum::toString).toList();
            UserDto userDto = new UserDto(user.getId(), user.getFullName(), helpOptions, user.getBonus());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto convertEntityToDto(User user) {
        List<String> helpOptions = user.getHelpOptionsList().stream().map(Enum::toString).toList();
        return new UserDto(user.getId(), user.getFullName(), helpOptions, user.getBonus());
    }

    @Override
    public User convertDtoToEntity(UserDto userDto) {
        return new User(UUID.randomUUID().toString(), userDto.getFullName());
    }
}
