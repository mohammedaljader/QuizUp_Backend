package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Dto.UserDto;


public interface IGameMapper {
    GameDto convertToDto(QuizDto quizDto, UserDto userDto);
}
