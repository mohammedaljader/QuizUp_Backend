package com.backend.QuizUp_Backend.Dto;

import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    String id;
    String fullName;
    List<String> helpOptions;
    Integer bonus;

    public UserDto(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
