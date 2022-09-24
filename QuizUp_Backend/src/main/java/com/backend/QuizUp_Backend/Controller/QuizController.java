package com.backend.QuizUp_Backend.Controller;

import com.backend.QuizUp_Backend.Dto.QuizDto;
import com.backend.QuizUp_Backend.Service.Interfaces.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class QuizController {

    private final IQuizService quizService;

    @Autowired
    public QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<QuizDto>> getAllQuizzes(){
        List<QuizDto> quizzes = quizService.getAllQuizzes();
        if(quizzes != null){
            return ResponseEntity.ok().body(quizzes);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable String id){
        QuizDto quiz = quizService.getQuizById(id);

        if(quiz != null){
            return ResponseEntity.ok().body(quiz);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> addQuiz(@RequestBody QuizDto quiz){
        if(quizService.addQuiz(quiz)){
            return ResponseEntity.ok().body("Quiz added successfully!");
        }else {
            return ResponseEntity.badRequest().body("Cannot add the quiz, please try again!");
        }
    }

    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable String id){
        if(quizService.deleteQuiz(id)){
            return ResponseEntity.ok().body("Quiz deleted successfully!");
        }else{
            return ResponseEntity.badRequest().body("Cannot delete the quiz, please give a valid id!");
        }
    }

    @PutMapping("/quiz")
    public ResponseEntity<String> updateQuiz(@RequestBody QuizDto quiz){
        if(quizService.updateQuiz(quiz)){
            return ResponseEntity.ok().body("Quiz updated successfully!");
        }else {
            return ResponseEntity.badRequest().body("Cannot update the quiz, please give a valid id!");
        }
    }


}
