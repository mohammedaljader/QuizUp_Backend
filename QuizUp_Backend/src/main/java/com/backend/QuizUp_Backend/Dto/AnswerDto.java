package com.backend.QuizUp_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerDto {
    Integer answerNumber;
    String answerText;
}
