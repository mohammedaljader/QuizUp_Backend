package com.backend.QuizUp_Backend.Repository;

import com.backend.QuizUp_Backend.Entities.Quiz;
import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import com.backend.QuizUp_Backend.Entities.enums.Level;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizRepository
        extends MongoRepository<Quiz, String> {

    List<Quiz> getQuizzesByCategory(Category category);

    List<Quiz> getQuizzesByComplexity(Complexity complexity);

    List<Quiz> getQuizzesByComplexityAndBonus(Complexity complexity, Integer bonus);

    List<Quiz> getQuizzesByComplexityAndLevel(Complexity complexity, Level level);
}
