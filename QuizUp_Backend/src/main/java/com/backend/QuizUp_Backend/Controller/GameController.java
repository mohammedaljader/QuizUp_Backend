package com.backend.QuizUp_Backend.Controller;

import com.backend.QuizUp_Backend.Dto.GameCheckDto;
import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Service.Interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GameController {

    private final IGameService gameService;


    @Autowired
    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/startGame/{userId}")
    public ResponseEntity<?> startGame(@PathVariable String userId){
        GameDto game = gameService.startGame(userId);
        if(game != null){
            return ResponseEntity.ok().body(game);
        }else {
            return ResponseEntity.badRequest().body("Cannot start a game, please try again!");
        }
    }

    @PostMapping("/checkGame")
    public ResponseEntity<?> gameCheck(@RequestBody GameCheckDto gameCheckDto){
        GameDto game = gameService.gameCheck(gameCheckDto.getUserId(),
                gameCheckDto.getQuizId(),
                gameCheckDto.getAnswer(),
                gameCheckDto.getHelpOption());
        if(game != null){
            return ResponseEntity.ok().body(game);
        }else {
            return ResponseEntity.badRequest().body("Cannot check the game, please try again!");
        }
    }
}
