package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends MongoRepository<User, String> {
}
