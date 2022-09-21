package com.backend.QuizUp_Backend.Entities;

import com.backend.QuizUp_Backend.Entities.enums.Category;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("quiz")
public class Quiz {
    @Id
    String id;
    Category category;
    String question;
    List<Answer> answers;
    Integer correctAnswer;
    Complexity complexity;
    Integer bonus;
}
