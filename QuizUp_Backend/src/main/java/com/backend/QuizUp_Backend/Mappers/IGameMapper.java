package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.*;

import java.util.List;


public interface IGameMapper {
    GameDto convertToDto(QuizDto quizDto, UserDto userDto);
    PublicDto convertPublicAnswersToDto(QuizDto quizDto, UserDto userDto, List<AnswerDto> publicAnswers);
}
