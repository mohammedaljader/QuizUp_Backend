package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.User;

import java.util.List;

public interface IUserMapper {

    List<UserDto> convertEntityToDto(List<User> users);

    UserDto convertEntityToDto(User user);

    User convertDtoToEntity(UserDto userDto);

}
