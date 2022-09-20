package com.backend.QuizUp_Backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("quiz")
public class Quiz {
    @Id
    String id;
    Category category;
    String question;
    List<Answer> answers;
    Integer correctAnswer;
}