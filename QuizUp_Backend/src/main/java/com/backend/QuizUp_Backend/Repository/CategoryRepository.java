package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository
        extends MongoRepository<Category, String> {
}
