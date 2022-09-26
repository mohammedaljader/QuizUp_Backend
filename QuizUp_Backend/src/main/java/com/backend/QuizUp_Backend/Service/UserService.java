package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.User;
import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
import com.backend.QuizUp_Backend.Mappers.IUserMapper;
import com.backend.QuizUp_Backend.Repository.UserRepository;
import com.backend.QuizUp_Backend.Service.Interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private final IUserMapper userMapper;


    @Autowired
    public UserService(UserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public boolean addUser(UserDto userDto) {
        User user = userMapper.convertDtoToEntity(userDto);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDto getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            return null;
        }
        return userMapper.convertEntityToDto(user.get());
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        Optional<User> oldUser = userRepository.findById(userDto.getId());
        User updatedUser;
        if(oldUser.isEmpty()){
            return false;
        }
        if(userDto.getHelpOptions().size() != 3){
            List<HelpOptions> helpOptions = userDto.getHelpOptions().stream().map(x -> Enum.valueOf(HelpOptions.class, x)).toList();
            updatedUser = new User(userDto.getId(),oldUser.get().getFullName(), helpOptions, userDto.getBonus());
        } else if (!Objects.equals(oldUser.get().getBonus(), userDto.getBonus())) {
            updatedUser = new User(userDto.getId(),oldUser.get().getFullName(),oldUser.get().getHelpOptionsList(), userDto.getBonus());
        }else {
            updatedUser = new User(userDto.getId(), userDto.getFullName());
        }
        userRepository.save(updatedUser);
        return true;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.convertEntityToDto(userRepository.findAll());
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
