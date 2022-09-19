package com.backend.QuizUp_Backend;

import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class QuizUpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizUpBackendApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(QuizRepository repository) {
		return args -> {
			Quiz quiz = new Quiz(UUID.randomUUID().toString(), "Test", "Test");
			Quiz quiz1 = new Quiz(UUID.randomUUID().toString(), "Test2", "Test2");
			repository.save(quiz);
			repository.save(quiz1);
		};
	}
}
