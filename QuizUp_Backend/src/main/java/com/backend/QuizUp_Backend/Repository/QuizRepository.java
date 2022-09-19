package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface QuizRepository
        extends MongoRepository<Quiz, String> {


    Optional<Quiz> findQuizByAnswer(String answer);
}
