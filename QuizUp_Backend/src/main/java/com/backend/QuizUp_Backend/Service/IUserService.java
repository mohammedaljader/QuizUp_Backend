package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Entities.User;

import java.util.Optional;

public interface IUserService {

    boolean addUser(User user);

    Optional<User> getUserById(String id);
}
