package com.backend.QuizUp_Backend.Entities;

import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("user")
public class User {
    @Id
    String id;
    String fullName;
    List<HelpOptions> helpOptionsList = new ArrayList<>();
    Integer bonus;

    public User(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.helpOptionsList.addAll(List.of(
                HelpOptions.deleteTwoQuestions,
                HelpOptions.callFriend,
                HelpOptions.askPublic));
        this.bonus = 0;
    }
}
