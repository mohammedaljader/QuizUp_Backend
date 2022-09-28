package com.backend.QuizUp_Backend.Mappers;

import com.backend.QuizUp_Backend.Dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameMapper implements IGameMapper {
    @Override
    public GameDto convertToDto(QuizDto quizDto, UserDto userDto) {
        return new GameDto(quizDto.getId(),
                userDto.getId(), userDto.getFullName(),
                quizDto.getQuestion(),
                quizDto.getAnswers(),
                userDto.getHelpOptions(),
                userDto.getBonus(),
                quizDto.getBonus(),"");
    }

    @Override
    public PublicDto convertPublicAnswersToDto(QuizDto quizDto, UserDto userDto, List<AnswerDto> publicAnswers) {
        return new PublicDto(quizDto.getId(),
                userDto.getId(), userDto.getFullName(),
                quizDto.getQuestion(),
                quizDto.getAnswers(),
                userDto.getHelpOptions(),
                userDto.getBonus(),
                quizDto.getBonus(),
                "",
                publicAnswers);
    }

    @Override
    public FriendDto convertFriendAnswersToDto(QuizDto quizDto, UserDto userDto, AnswerDto friendDto) {
        return new FriendDto(quizDto.getId(),
                userDto.getId(), userDto.getFullName(),
                quizDto.getQuestion(),
                quizDto.getAnswers(),
                userDto.getHelpOptions(),
                userDto.getBonus(),
                quizDto.getBonus(),
                "",
                friendDto);
    }
}
