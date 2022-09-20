package com.backend.QuizUp_Backend;

import com.backend.QuizUp_Backend.Entities.Answer;
import com.backend.QuizUp_Backend.Entities.Category;
import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Repository.CategoryRepository;
import com.backend.QuizUp_Backend.Repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class QuizUpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizUpBackendApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(QuizRepository repository, CategoryRepository categoryRepository) {
		return args -> {
			Category category = new Category(UUID.randomUUID().toString(), "Test");

			categoryRepository.save(category);

			List<Answer> answerList = new ArrayList<>();

			answerList.add(new Answer( "test1"));
			answerList.add(new Answer("test2"));
			answerList.add(new Answer( "test2"));
			answerList.add(new Answer( "test2"));

			Quiz quiz = new Quiz(UUID.randomUUID().toString(),category, "Test",  answerList,1);
			repository.save(quiz);
		};
	}
}
