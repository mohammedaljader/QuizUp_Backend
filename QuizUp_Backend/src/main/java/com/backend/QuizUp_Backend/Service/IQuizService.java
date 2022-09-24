package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Entities.Quiz;

import java.util.List;
import java.util.Optional;

public interface IQuizService {

    boolean addQuiz(Quiz quiz);

    Optional<Quiz> getQuizById(String id);

    boolean updateQuiz(Quiz quiz);

    List<Quiz> getAllQuizzes();

    boolean deleteQuiz(String id);
}
