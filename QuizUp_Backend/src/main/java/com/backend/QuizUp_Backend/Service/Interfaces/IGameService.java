package com.backend.QuizUp_Backend.Service.Interfaces;

import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.TopTenDto;
import com.backend.QuizUp_Backend.Dto.UserDto;

import java.util.List;


public interface IGameService {


    GameDto gameCheck(String userId, String quizId,Integer answer, String helpOption);

    GameDto startGame(String userId);

    List<TopTenDto> getTopTen();


}
