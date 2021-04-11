package com.codeoftheweb.salvo.Controllers;

import com.codeoftheweb.salvo.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GamesController {
    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public List<Object> getGames(){
        return gameService.getGames();
    }

}
