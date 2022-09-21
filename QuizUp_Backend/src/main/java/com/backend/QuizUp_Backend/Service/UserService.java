package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Entities.User;
import com.backend.QuizUp_Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
}
