package com.backend.QuizUp_Backend.Entities;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Answer {

    private static final AtomicInteger count = new AtomicInteger(0);
    Integer answerNumber;
    String answerText;


    public Answer(String answerText){
        this.answerText= answerText;
        this.answerNumber = count.incrementAndGet();
    }
}
