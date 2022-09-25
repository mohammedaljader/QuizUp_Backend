package com.backend.QuizUp_Backend;

import com.backend.QuizUp_Backend.Dto.UserDto;
import com.backend.QuizUp_Backend.Entities.User;
import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
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


	@Bean
	CommandLineRunner commandLineRunner(IQuizService quizService, IUserService userService) {
		return args -> {
//			List<Answer> answerList = new ArrayList<>();
//
//			answerList.add(new Answer( "test1"));
//			answerList.add(new Answer( "test2"));
//			answerList.add(new Answer( "test2"));
//			answerList.add(new Answer( "test2"));
//
//
//			Quiz quiz = new Quiz(UUID.randomUUID().toString(), Category.Films, "Test",  answerList,1,
//					Complexity.Easy,100);
//
//			quizService.addQuiz(quiz);

//			String userid = UUID.randomUUID().toString();
//
//			UserDto userDto = new UserDto(userid, "Mohammed");
//			userService.addUser(userDto);
//
//
//			// test update function
//			UserDto updateUserDto = new UserDto(userid,"Mohammed",List.of("deleteTwoQuestions", "askPublic"), 100);
//
//			userService.updateUser(updateUserDto);


//			boolean result = userService.deleteUser(userid);
//			log.info("deleted is : "+ result);
		};
	}
}
