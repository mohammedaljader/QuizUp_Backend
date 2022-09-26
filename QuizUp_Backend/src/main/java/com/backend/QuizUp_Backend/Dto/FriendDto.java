package com.backend.QuizUp_Backend.Dto;

import java.util.List;

public class FriendDto extends GameDto {
    AnswerDto friendAnswer;

    public FriendDto(String quizId, String userId, String fullName, String question, List<AnswerDto> answers, List<String> helpOptions, Integer userBonus, Integer quizBonus, AnswerDto friendAnswer) {
        super(quizId, userId, fullName, question, answers, helpOptions, userBonus, quizBonus);
        this.friendAnswer = friendAnswer;
    }

    @Override
    public String toString() {
        return "FriendDto{" +
                "friendAnswer=" + friendAnswer +
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
