package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.Quiz;

import java.util.List;
import java.util.Optional;

public interface IQuizService {

    boolean addQuiz(QuizDto quizDto);

    QuizDto getQuizById(String id);

    boolean updateQuiz(QuizDto quizDto);

    List<QuizDto> getAllQuizzes();

    boolean deleteQuiz(String id);
}
