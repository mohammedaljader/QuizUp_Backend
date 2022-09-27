package com.backend.QuizUp_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    String quizId;
    String userId;
    String fullName;
    String question;
    List<AnswerDto> answers;
    List<String> helpOptions;
    Integer userBonus;
    Integer quizBonus;
}
