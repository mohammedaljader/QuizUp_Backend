package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class GameMapper implements IGameMapper {
    @Override
    public GameDto convertToDto(QuizDto quizDto, UserDto userDto) {
        return new GameDto(quizDto.getId(),
                userDto.getId(), userDto.getFullName(),
                quizDto.getQuestion(),
                quizDto.getAnswers(),
                userDto.getHelpOptions(),
                userDto.getBonus(),
                quizDto.getBonus());
    }
}
