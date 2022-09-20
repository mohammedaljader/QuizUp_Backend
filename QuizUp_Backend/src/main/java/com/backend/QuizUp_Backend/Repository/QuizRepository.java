package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface QuizRepository
        extends MongoRepository<Quiz, String> {

}
