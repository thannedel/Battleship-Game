package com.codeoftheweb.salvo.Controllers;

import com.codeoftheweb.salvo.Services.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaderBoardController {

    @Autowired
    LeaderBoardService leaderBoardService;
    @GetMapping("/leaderboard")
    public List<Object> getLeaderBoard(){
        return leaderBoardService.getLeaderBoard();
    }
}
