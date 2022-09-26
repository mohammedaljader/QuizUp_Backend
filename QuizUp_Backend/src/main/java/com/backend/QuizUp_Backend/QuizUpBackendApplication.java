package com.backend.QuizUp_Backend;

import com.backend.QuizUp_Backend.Dto.AnswerDto;
import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
import com.backend.QuizUp_Backend.Service.Interfaces.IGameService;
import com.backend.QuizUp_Backend.Service.Interfaces.IQuizService;
import com.backend.QuizUp_Backend.Service.Interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class QuizUpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizUpBackendApplication.class, args);
	}


//	@Bean
//	CommandLineRunner commandLineRunner(IQuizService quizService, IUserService userService, IGameService gameService) {
//		return args -> {
//			List<AnswerDto> answerList = new ArrayList<>();
//
//			answerList.add(new AnswerDto(1, "test1"));
//			answerList.add(new AnswerDto(2, "test2"));
//			answerList.add(new AnswerDto( 3,"test3"));
//			answerList.add(new AnswerDto( 4,"test4"));
//
//			String quizId = UUID.randomUUID().toString();
//			QuizDto quiz = new QuizDto(quizId,"test",
//					answerList, Category.Films.name(), 1,Complexity.Easy.name(), 100);
//
//			QuizDto quiz1 = new QuizDto(UUID.randomUUID().toString(),"test",
//					answerList, Category.Films.name(), 1,Complexity.Easy.name(), 200);
//
//			quizService.addQuiz(quiz);
//			quizService.addQuiz(quiz1);
//
//			String userid = UUID.randomUUID().toString();
//
//			UserDto userDto = new UserDto(userid, "Mohammed");
//			userService.addUser(userDto);
//
//			GameDto gameDto = gameService.startGame(userid);
//			log.info(gameDto.toString());
//
//			GameDto gameDto1 = gameService.gameCheck(userid, gameDto.getQuizId(),1,"");
//
//			GameDto gameDto2 = gameService.gameCheck(userid, gameDto1.getQuizId(),1,"");
//			log.info(gameDto2.getUserBonus().toString());
//
//		};
//	}
}
