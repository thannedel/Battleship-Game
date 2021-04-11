package com.codeoftheweb.salvo.Controllers;

import com.codeoftheweb.salvo.Services.GameViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GameViewController {

    @Autowired
    GameViewService gameViewService;


    @GetMapping("/game_view/{gamePlayerId}")
    Map<String,Object> getGamePlayerById(@PathVariable Long gamePlayerId) {
        return gameViewService.getGamePlayerById(gamePlayerId);
    }

}




/*@GetMapping("/game_view/{gamePlayerId}")
    Optional<GamePlayer> getGamePlayerById(@PathVariable long gamePlayerId) {
        Optional<GamePlayer> gamePlayer = gamePlayerRepository.findById(gamePlayerId);
        return gamePlayer.isPresent() ? gamePlayer : null;
    }*/

