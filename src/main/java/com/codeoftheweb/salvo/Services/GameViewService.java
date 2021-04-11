package com.codeoftheweb.salvo.Services;

import com.codeoftheweb.salvo.Entities.Game;
import com.codeoftheweb.salvo.Entities.GamePlayer;
import com.codeoftheweb.salvo.Entities.Ship;
import com.codeoftheweb.salvo.Repositories.GamePlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameViewService {
    @Autowired
    GamePlayerRepository gamePlayerRepository;
    @Autowired
    GameService gameService;

    public Map<String,Object> getGamePlayerById(Long gamePlayerId){
        Map<String,Object> gameDTO = new LinkedHashMap<>();
        GamePlayer currentGamePlayer = gamePlayerRepository.findById(gamePlayerId).orElse(null);
        Game game = currentGamePlayer.getGame();
        gameDTO.put("id", game.getId());
        gameDTO.put("created",game.getDate());
        gameDTO.put("gamePlayers",gamePlayersList(game));
        gameDTO.put("ships",shipsOfGamePlayer(currentGamePlayer));
        gameDTO.put("salvoes", getSalvoByGamePlayer(game));

        return gameDTO;
    }


    final List<Object> gamePlayersList(Game game){
        return  game.getGamePlayers().stream().sorted(Comparator.comparing(GamePlayer::getId))
                .map(gamePlayer -> gameService.gamePlayersDTO(gamePlayer))
                .collect(Collectors.toList());
    }

    //  Get Ships Of GamePlayer
    final List<Object> shipsOfGamePlayer(GamePlayer currentGamePlayer){
        return currentGamePlayer.getShips().stream().sorted(Comparator.comparing(Ship::getId)).collect(Collectors.toList());
    }

    //Get Salvo Information

    final Map<String,Object> getSalvoByGamePlayer(Game game){
        Map<String,Object> dto = new LinkedHashMap<>();
        game.getGamePlayers().stream().forEach(gamePlayer -> {
            dto.put(String.valueOf(gamePlayer.getId()),getSalvoDTO(gamePlayer));
        });
        return dto;
    }
    final Map<String,Object> getSalvoDTO(GamePlayer gamePlayer){
        Map<String,Object> dto = new LinkedHashMap<>();
        gamePlayer.getSalvoes().stream().forEach(salvo ->
        {
            dto.put((String.valueOf(salvo.getTurn())),salvo.getSalvoLocations());
        });
        return  dto;
    }
}
