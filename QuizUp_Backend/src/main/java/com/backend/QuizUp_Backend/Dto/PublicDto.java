package com.backend.QuizUp_Backend.Dto;

import java.util.List;

public class PublicDto extends GameDto{

    List<AnswerDto> publicAnswers;

    public PublicDto(String quizId, String userId, String fullName, String question, List<AnswerDto> answers, List<String> helpOptions, Integer userBonus, Integer quizBonus,String message,List<AnswerDto> publicAnswers) {
        super(quizId, userId, fullName, question, answers, helpOptions, userBonus, quizBonus, message);

        this.publicAnswers = publicAnswers;
    }

    @Override
    public String toString() {
        return "PublicDto{" +
                "publicAnswers=" + publicAnswers +
                ", quizId='" + quizId + '\'' +
                ", userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                ", helpOptions=" + helpOptions +
                ", userBonus=" + userBonus +
                ", quizBonus=" + quizBonus +
                '}';
    }
}
