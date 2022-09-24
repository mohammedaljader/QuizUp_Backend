package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.UserDto;

import java.util.List;

public interface IUserService {

    boolean addUser(UserDto userDto);

    UserDto getUserById(String id);

    boolean updateUser(UserDto userDto);

    List<UserDto> getAllUsers();

    boolean deleteUser(String id);
}
