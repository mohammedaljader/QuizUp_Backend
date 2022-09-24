package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Entities.User;
import com.backend.QuizUp_Backend.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
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

    @Override
    public boolean updateUser(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        User updatedUser;

        if(oldUser.isEmpty()){
            return false;
        }

        if(user.getHelpOptionsList().size() != 3 && !Objects.equals(oldUser.get().getBonus(), user.getBonus())){
            updatedUser = new User(user.getId(),oldUser.get().getFullName(), user.getHelpOptionsList(), user.getBonus());
        } else if (!Objects.equals(oldUser.get().getBonus(), user.getBonus())) {
            updatedUser = new User(user.getId(),oldUser.get().getFullName(),oldUser.get().getHelpOptionsList(), user.getBonus());
        }else {
            updatedUser = new User(user.getId(), user.getFullName());
        }
        userRepository.save(updatedUser);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            return false;
        }
        userRepository.delete(user.get());
        return true;
    }
}
