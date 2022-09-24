package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Dto.AnswerDto;
import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Mappers.IGameMapper;
import com.backend.QuizUp_Backend.Service.Interfaces.IGameService;
import com.backend.QuizUp_Backend.Service.Interfaces.IQuizService;
import com.backend.QuizUp_Backend.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class GameService implements IGameService {

    private final IQuizService quizService;
    private final IUserService userService;
    
    private final IGameMapper gameMapper;

    @Autowired
    public GameService(IQuizService quizService, IUserService userService,IGameMapper gameMapper) {
        this.quizService = quizService;
        this.userService = userService;
        this.gameMapper = gameMapper;
    }

    @Override
    public GameDto getNewGame(String userId) {
        UserDto userDto = userService.getUserById(userId);
        Random randomizer = new Random();
        if(userDto.getBonus() <= 1000){
            List<QuizDto> quizzes = quizService.getQuizzesByComplexity("Easy");
            QuizDto randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        } else if (userDto.getBonus() > 1000 && userDto.getBonus() <= 32000) {
            List<QuizDto> quizzes = quizService.getQuizzesByComplexity("Intermediate");
            QuizDto randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        } else if (userDto.getBonus() > 32000 && userDto.getBonus() <= 1000000) {
            List<QuizDto> quizzes = quizService.getQuizzesByComplexity("Hard");
            QuizDto randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        }
        return null;
    }

    @Override
    public boolean checkGame(String userId, String quizId, Integer answer) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);

        if(Objects.equals(quizDto.getCorrectAnswer(), answer)){
            userDto.setBonus(quizDto.getBonus());
            userService.updateUser(userDto);
            return true;
        }

        return false;
    }

    @Override
    public GameDto deleteTwoAnswers(String userId, String quizId) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);
        List<AnswerDto> answersToSend = new ArrayList<>();
        Random randomizer = new Random();

        List<AnswerDto> answerDtos = quizDto.getAnswers();

        for(AnswerDto answerDto : answerDtos){
            if(Objects.equals(answerDto.getAnswerNumber(), quizDto.getCorrectAnswer())){
                answersToSend.add(answerDto);
                answerDtos.remove(answerDto);
            }
        }

        AnswerDto randomAnswer = answerDtos.get(randomizer.nextInt(answerDtos.size()));
        answersToSend.add(randomAnswer);
        quizDto.setAnswers(answersToSend);
        if(answersToSend.size() == 2){
            return gameMapper.convertToDto(quizDto, userDto);
        }
        return null;
    }

    @Override
    public GameDto callFriend(String userId, String quizId) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);
        List<AnswerDto> answersToSend = new ArrayList<>();

        List<AnswerDto> answerDtos = quizDto.getAnswers();

        for(AnswerDto answerDto : answerDtos){
            if(Objects.equals(answerDto.getAnswerNumber(), quizDto.getCorrectAnswer())){
                answersToSend.add(answerDto);
            }
        }
        quizDto.setAnswers(answersToSend);
        return gameMapper.convertToDto(quizDto, userDto);
    }
}
