package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository
        extends MongoRepository<Quiz, String> {

//    Quiz findByQuiz_id(String id);
}
