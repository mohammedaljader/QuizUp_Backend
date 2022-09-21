package com.backend.QuizUp_Backend;

import com.backend.QuizUp_Backend.Entities.Answer;
import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Entities.User;
import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import com.backend.QuizUp_Backend.Repository.QuizRepository;
import com.backend.QuizUp_Backend.Repository.UserRepository;
import com.backend.QuizUp_Backend.Service.IQuizService;
import com.backend.QuizUp_Backend.Service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
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
			List<Answer> answerList = new ArrayList<>();

			answerList.add(new Answer( "test1"));
			answerList.add(new Answer( "test2"));
			answerList.add(new Answer( "test2"));
			answerList.add(new Answer( "test2"));


			Quiz quiz = new Quiz(UUID.randomUUID().toString(), Category.Films, "Test",  answerList,1,
					Complexity.Easy,100);

			quizService.addQuiz(quiz);

			User user = new User(UUID.randomUUID().toString(), "Mohammed");
			userService.addUser(user);
		};
	}
}
