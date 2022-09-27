package com.backend.QuizUp_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    String id;
    String question;
    List<AnswerDto> answers;
    String Category;
    Integer correctAnswer;
    String complexity;
    Integer bonus;
}
