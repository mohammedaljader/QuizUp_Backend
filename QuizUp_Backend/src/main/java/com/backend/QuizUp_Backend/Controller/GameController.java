package com.backend.QuizUp_Backend.Controller;

import com.backend.QuizUp_Backend.Dto.GameCheckDto;
import com.backend.QuizUp_Backend.Dto.GameDto;
import com.backend.QuizUp_Backend.Dto.MessageResponse;
import com.backend.QuizUp_Backend.Dto.TopTenDto;
import com.backend.QuizUp_Backend.Service.Interfaces.IGameService;
import com.backend.QuizUp_Backend.Util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
            return ResponseEntity.badRequest().body(new MessageResponse("Cannot start a game, please try again!"));
        }
    }

    @GetMapping("/topTen")
    public ResponseEntity<?> getTopTen(){
        List<TopTenDto> users = gameService.getTopTen();
        if(users != null){
            return ResponseEntity.ok().body(users);
        }else {
            return ResponseEntity.badRequest().body(new MessageResponse("Cannot get top ten, please try again!"));
        }
    }

    @PostMapping("/checkGame")
    public ResponseEntity<?> gameCheck(@RequestBody GameCheckDto gameCheckDto) {
        GameDto game = gameService.gameCheck(gameCheckDto.getUserId(),
                gameCheckDto.getQuizId(),
                gameCheckDto.getAnswer(),
                gameCheckDto.getHelpOption());
        if(game != null){
            if (game.getMessage().isEmpty()) {
                return ResponseEntity.ok().body(game);
            } else {
                if (Objects.equals(game.getMessage(), MessageUtil.winGame)){
                    return ResponseEntity.ok().body(new MessageResponse("You win the game!"));
                }else if (Objects.equals(game.getMessage(), MessageUtil.loseGame)){
                    return ResponseEntity.ok().body(new MessageResponse("Game over! You lost the game!"));
                }
            }
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Cannot check the game, please try again!"));
    }
}
