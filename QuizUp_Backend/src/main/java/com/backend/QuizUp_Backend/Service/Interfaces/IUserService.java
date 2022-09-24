package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    boolean addUser(UserDto userDto);

    UserDto getUserById(String id);

    boolean updateUser(UserDto userDto);

    List<UserDto> getAllUsers();

    boolean deleteUser(String id);
}
