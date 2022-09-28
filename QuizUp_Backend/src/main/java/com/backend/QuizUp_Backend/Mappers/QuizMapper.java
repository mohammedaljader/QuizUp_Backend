package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.AnswerDto;
import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Entities.Answer;
import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import com.backend.QuizUp_Backend.Entities.enums.Level;
import com.backend.QuizUp_Backend.Util.LevelUtil;
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
            List<AnswerDto> answers = quiz.getAnswers().stream().map(x -> new AnswerDto(x.getAnswerNumber(), x.getAnswerText())).toList();
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
        List<AnswerDto> answers = quiz.getAnswers().stream().map(x -> new AnswerDto(x.getAnswerNumber(), x.getAnswerText())).toList();
        return new QuizDto(quiz.getId(), quiz.getQuestion(), answers,
                quiz.getCategory().toString(),
                quiz.getCorrectAnswer(),
                quiz.getComplexity().toString(),
                quiz.getBonus());
    }

    @Override
    public Quiz convertDtoToEntity(QuizDto quizDto,boolean isNewQuiz) {
        if(isNewQuiz){
            return new Quiz(UUID.randomUUID().toString(),
                    Enum.valueOf(Category.class,quizDto.getCategory()),
                    quizDto.getQuestion(),
                    quizDto.getAnswers().stream()
                            .map(x -> new Answer(x.getAnswerNumber(), x.getAnswerText())).toList(),
                    quizDto.getCorrectAnswer(),
                    Enum.valueOf(Complexity.class,quizDto.getComplexity()),
                    quizDto.getBonus(),
                    LevelUtil.getLevel(quizDto.getBonus()));
        }else {
            return new Quiz(quizDto.getId(),
                    Enum.valueOf(Category.class,quizDto.getCategory()),
                    quizDto.getQuestion(),
                    quizDto.getAnswers().stream()
                            .map(x -> new Answer(x.getAnswerNumber(), x.getAnswerText())).toList(),
                    quizDto.getCorrectAnswer(),
                    Enum.valueOf(Complexity.class,quizDto.getComplexity()),
                    quizDto.getBonus(), LevelUtil.getLevel(quizDto.getBonus()));
        }
    }


}
