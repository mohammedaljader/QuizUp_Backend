package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.PublicDto;


public interface IGameService {

    GameDto getNewGame(String userId);

    boolean checkGame(String userId, String quizId, Integer answer);

    GameDto deleteTwoAnswers(String userId, String quizId);

    GameDto callFriend(String userId, String quizId);

    PublicDto askPublic(String userId, String quizId);
}
