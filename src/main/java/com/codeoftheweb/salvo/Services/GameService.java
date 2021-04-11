package com.codeoftheweb.salvo.Services;

import com.codeoftheweb.salvo.Entities.Game;
import com.codeoftheweb.salvo.Entities.GamePlayer;
import com.codeoftheweb.salvo.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;



    public List<Object> getGames(){
        return gameRepository
                .findAll()
                .stream().sorted(Comparator.comparing(Game::getId).reversed())
                .map(game -> makeGameDTO(game)).collect(Collectors.toList());
    }

    private Map<String,Object> makeGameDTO (Game game){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",game.getId());
        dto.put("created", game.getDate());
        dto.put("gamePlayers", gamePlayersList(game));
        return dto;
    }

    private List<Object> gamePlayersList(Game game){
        List<Object> gamePlayersList = game.getGamePlayers().stream().sorted(Comparator.comparing(GamePlayer::getId))
                .map(gamePlayer -> gamePlayersDTO(gamePlayer)).collect(Collectors.toList());
        return gamePlayersList;
    }

    public Map<String,Object> gamePlayersDTO (GamePlayer gamePlayer){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",gamePlayer.getId());
        dto.put("player",gamePlayer.getPlayer());
        return dto;
    }
}
