package com.scramble.scramblegame.Controller;

import org.springframework.ui.Model;
import com.scramble.scramblegame.Handler.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }



    @GetMapping("/game")
    public String game(Model model) {
        String randomWord = gameService.getOriginalWord();
        String mixedWord = gameService.getScrambledWord();

        model.addAttribute("randomWord", randomWord);
        model.addAttribute("mixedWord", mixedWord);
        return "game";
    }

    @PostMapping("/game")
    public String gameResult(@RequestParam(value = "inputString", required = false) String userGuess, Model model) {
        String randomWord = gameService.getOriginalWord();
        model.addAttribute("randomWord", gameService.getOriginalWord());
        model.addAttribute("mixedWord", gameService.getScrambledWord());
        if(userGuess != null) {
            if(userGuess.equals(randomWord)) {
                model.addAttribute("message", "Yes");
                gameService.restartGame();
                return "redirect:/game";
            }
            else {
                model.addAttribute("message", "No");
            }
        }
        return "game";
    }

}
