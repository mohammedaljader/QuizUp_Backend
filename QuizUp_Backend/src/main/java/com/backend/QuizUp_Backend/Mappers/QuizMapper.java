package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.Answer;
import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class QuizMapper implements IQuizMapper{
    @Override
    public List<QuizDto> convertEntityToDto(List<Quiz> quizzes) {
        List<QuizDto> quizDtoArrayList = new ArrayList<>();
        for(Quiz quiz : quizzes){
            List<String> answers = quiz.getAnswers().stream().map(Answer::getAnswerText).toList();
            QuizDto quizDto = new QuizDto(quiz.getId(), quiz.getQuestion(), answers,
                    quiz.getCategory().toString(),
                    quiz.getCorrectAnswer(),
                    quiz.getComplexity().toString(),
                    quiz.getBonus());
            quizDtoArrayList.add(quizDto);
        }
        return quizDtoArrayList;
    }

    @Override
    public QuizDto convertEntityToDto(Quiz quiz) {
        List<String> answers = quiz.getAnswers().stream().map(Answer::getAnswerText).toList();
        return new QuizDto(quiz.getId(), quiz.getQuestion(), answers,
                quiz.getCategory().toString(),
                quiz.getCorrectAnswer(),
                quiz.getComplexity().toString(),
                quiz.getBonus());
    }

    @Override
    public Quiz convertDtoToEntity(QuizDto quizDto) {
        List<Answer> answers = quizDto.getAnswers().stream().map(Answer::new).toList();
        return new Quiz(UUID.randomUUID().toString(),
                Enum.valueOf(Category.class,quizDto.getCategory()),
                quizDto.getQuestion(),
                answers,
                quizDto.getCorrectAnswer(),
                Enum.valueOf(Complexity.class,quizDto.getComplexity()),
                quizDto.getBonus());
    }
}
