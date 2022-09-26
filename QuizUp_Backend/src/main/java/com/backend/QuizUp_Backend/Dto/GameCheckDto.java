package com.backend.QuizUp_Backend.Dto;

import lombok.Data;

@Data
public class GameCheckDto {
    String userId;
    String quizId;
    Integer answer;
    String helpOption;
}
