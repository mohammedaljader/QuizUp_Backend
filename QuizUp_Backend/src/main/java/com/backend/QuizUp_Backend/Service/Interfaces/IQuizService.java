package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.enums.Level;

import java.util.List;

public interface IQuizService {

    boolean addQuiz(QuizDto quizDto);

    QuizDto getQuizById(String id);

    boolean updateQuiz(QuizDto quizDto);

    List<QuizDto> getAllQuizzes();

    boolean deleteQuiz(String id);

    List<QuizDto> getQuizzesByCategory(String category);

    List<QuizDto>  getQuizzesByComplexity(String complexity);

    List<QuizDto> getQuizzesByComplexityAndBonus(String complexity, Integer bonus);

    List<QuizDto> getQuizzesByComplexityAndLevel(String complexity, Level level);
}
