package com.backend.QuizUp_Backend.Mappers;


import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.Quiz;

import java.util.List;

public interface IQuizMapper {
    List<QuizDto> convertEntityToDto(List<Quiz> quizzes);

    QuizDto convertEntityToDto(Quiz quiz);

    Quiz convertDtoToEntity(QuizDto quizDto, boolean isNewQuiz);
}
