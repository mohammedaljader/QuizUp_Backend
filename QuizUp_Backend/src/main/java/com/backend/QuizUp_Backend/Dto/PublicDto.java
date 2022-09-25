package com.backend.QuizUp_Backend.Dto;

import java.util.List;

public class PublicDto extends GameDto{

    List<AnswerDto> publicAnswers;

    public PublicDto(String quizId, String userId, String fullName, String question, List<AnswerDto> answers, List<String> helpOptions, Integer userBonus, Integer quizBonus,List<AnswerDto> publicAnswers) {
        super(quizId, userId, fullName, question, answers, helpOptions, userBonus, quizBonus);

        this.publicAnswers = publicAnswers;
    }
}
