package com.codeoftheweb.salvo.Services;

import com.codeoftheweb.salvo.Entities.Player;
import com.codeoftheweb.salvo.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeaderBoardService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Object> getLeaderBoard(){
        return playerRepository.findAll().stream().map(player -> scoresDto(player)
        ).collect(Collectors.toList());
    }

    final Map<String,Object> scoresDto(Player player){
        List<Object> list = player.getScores().stream().map(score -> score.getScore()).collect(Collectors.toList());
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("player",player.getUsername());
        dto.put("win", Collections.frequency(list,1.0));
        dto.put("loss",Collections.frequency(list,0.0));
        dto.put("tie",Collections.frequency(list,0.5));
        dto.put("total",player.getScores().stream().mapToDouble(score -> score.getScore()).sum());
    return dto;
    }

}
