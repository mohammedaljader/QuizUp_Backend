package com.backend.QuizUp_Backend.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Quiz {
    @Id
    String quiz_id;
    String quiz_question;
    String quiz_answer;
}
