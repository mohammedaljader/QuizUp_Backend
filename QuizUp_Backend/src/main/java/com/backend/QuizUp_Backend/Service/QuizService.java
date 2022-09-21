package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService implements IQuizService {

    private final QuizRepository quizRepository;


    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public boolean addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return true;
    }

    @Override
    public Optional<Quiz> getQuizById(String id) {
        return quizRepository.findById(id);
    }
}
