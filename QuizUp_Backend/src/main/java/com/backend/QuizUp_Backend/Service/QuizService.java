package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Mappers.IQuizMapper;
import com.backend.QuizUp_Backend.Repository.QuizRepository;
import com.backend.QuizUp_Backend.Service.Interfaces.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService {

    private final QuizRepository quizRepository;

    private final IQuizMapper quizMapper;


    @Autowired
    public QuizService(QuizRepository quizRepository, IQuizMapper quizMapper) {
        this.quizMapper = quizMapper;
        this.quizRepository = quizRepository;
    }

    @Override
    public boolean addQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.convertDtoToEntity(quizDto);
        quizRepository.save(quiz);
        return true;
    }

    @Override
    public QuizDto getQuizById(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isEmpty()){
            return null;
        }
        return quizMapper.convertEntityToDto(quiz.get());
    }

    @Override
    public boolean updateQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.convertDtoToEntity(quizDto);
        Quiz oldQuiz = new Quiz(quiz.getId(), quiz.getCategory(), quiz.getQuestion()
        ,quiz.getAnswers(), quiz.getCorrectAnswer(), quiz.getComplexity(), quiz.getBonus());

        quizRepository.save(oldQuiz);

        return true;
    }

    @Override
    public List<QuizDto> getAllQuizzes() {
        return quizMapper.convertEntityToDto(quizRepository.findAll());
    }

    @Override
    public boolean deleteQuiz(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);

        if(quiz.isEmpty()){
            return false;
        }
        quizRepository.delete(quiz.get());
        return true;
    }
}
