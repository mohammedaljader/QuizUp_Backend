package com.backend.QuizUp_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuizDto {
    String id;
    String question;
    List<String> answers;
    String Category;
    Integer correctAnswer;
    String complexity;
    Integer bonus;
}
