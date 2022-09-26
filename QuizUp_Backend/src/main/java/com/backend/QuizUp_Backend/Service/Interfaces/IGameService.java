package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.GameDto;


public interface IGameService {

    GameDto getQuizByHelpOptions(String userId, String quizId, String helpOption);

    GameDto gameCheck(String userId, String quizId,Integer answer, String helpOption);

    GameDto startGame(String userId);
}
