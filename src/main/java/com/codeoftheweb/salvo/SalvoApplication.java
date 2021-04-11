package com.codeoftheweb.salvo;

import com.codeoftheweb.salvo.Entities.*;
import com.codeoftheweb.salvo.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
    public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData (PlayerRepository playerRepository, GameRepository gameRepository,
									   GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository,
									   SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
		return (args) -> {
			Player p1 = new Player("Jack", "13");
			playerRepository.save(p1);
			Player p2 = new Player("Chloe", "12");
			playerRepository.save(p2);
			Player p3 = new Player("Ki","ki");
			playerRepository.save(p3);
			Player p4 = new Player("David","dav");
			playerRepository.save(p4);
			Player p5 = new Player("Michelle", "123");
			playerRepository.save(p5);

			//Creating games
			Date date = new Date();
			Date date1hLater = Date.from(date.toInstant().plusSeconds(3600));
			Date date2hLater = Date.from(date.toInstant().plusSeconds(7200));
			Date date2misHLater = Date.from(date.toInstant().plusSeconds(9000));
			Game game1 = new Game(date);
			gameRepository.save(game1);
			Game game2 = new Game(date1hLater);
			gameRepository.save(game2);
			Game game3 = new Game(date2hLater);
			gameRepository.save(game3);
			Game game4 = new Game(date2misHLater);
			gameRepository.save(game4);

			//a game must have max two players
			GamePlayer gamePlayer1 = new GamePlayer(p1, game1);
			gamePlayerRepository.save(gamePlayer1);
			GamePlayer gamePlayer2 = new GamePlayer(p2, game2);
			gamePlayerRepository.save(gamePlayer2);
			GamePlayer gamePlayer3 = new GamePlayer(p3, game3);
			gamePlayerRepository.save(gamePlayer3);
			GamePlayer gamePlayer4 = new GamePlayer(p2, game1);
			gamePlayerRepository.save(gamePlayer4);
			GamePlayer gamePlayer5 = new GamePlayer(p5, game2);
			gamePlayerRepository.save(gamePlayer5);
			GamePlayer gamePlayer6 = new GamePlayer(p2, game3);
			gamePlayerRepository.save(gamePlayer6);
			GamePlayer gamePlayer7 = new GamePlayer(p5, game4);
			gamePlayerRepository.save(gamePlayer7);
			GamePlayer gamePlayer8 = new GamePlayer(p3, game4);
			gamePlayerRepository.save(gamePlayer8);


			//Ship (type, gamePlayer and location)
			Ship ship1 = new Ship("Cruiser", new ArrayList<>(Arrays.asList("A9", "B9", "C9")));
			gamePlayer1.addShip(ship1);
			shipRepository.save(ship1);


			Ship ship6 = new Ship("Destroyer", new ArrayList<>(Arrays.asList("F4", "F5","F6")));
			gamePlayer1.addShip((ship6));
			shipRepository.save(ship6);


			Ship ship2 = new Ship("Destroyer", new ArrayList<>(Arrays.asList("H2", "H3", "H4")));
			gamePlayer2.addShip((ship2));
			shipRepository.save(ship2);



			Ship ship3 = new Ship("Submarine", new ArrayList<>(Arrays.asList("E1", "F1", "G1")));
			gamePlayer2.addShip(ship3);
			shipRepository.save(ship3);



			Ship ship4 = new Ship("Patrol Boat", new ArrayList<>(Arrays.asList("A7", "A8", "A9")));
			gamePlayer4.addShip((ship4));
			shipRepository.save(ship4);



			Ship ship5 = new Ship("Patrol Boat", new ArrayList<>(Arrays.asList("B7", "B8", "B9")));
			gamePlayer5.addShip(ship5);
			shipRepository.save(ship5);



			Ship ship7 = new Ship("Patrol Boat",  new ArrayList<>(Arrays.asList("D7", "D8", "D9")));
			gamePlayer8.addShip(ship7);
			shipRepository.save(ship7);

			Salvo salvo1 = new Salvo(1, new ArrayList<>(Arrays.asList("A3","B5","F9","D3","K6")));
			gamePlayer1.addSalvo(salvo1);
			salvoRepository.save(salvo1);


			Salvo salvo2 = new Salvo(2, new ArrayList<>(Arrays.asList("J5","A8")));
			gamePlayer1.addSalvo(salvo2);
			salvoRepository.save(salvo2);


			Salvo salvo3 = new Salvo(3, new ArrayList<>(Arrays.asList("J5","H4")));
			gamePlayer2.addSalvo(salvo3);
			salvoRepository.save(salvo3);


			Salvo salvo4 = new Salvo(2, new ArrayList<>(Arrays.asList("C5","E6")));
			gamePlayer2.addSalvo(salvo4);
			salvoRepository.save(salvo4);


			Salvo salvo5 = new Salvo(1, new ArrayList<>(Arrays.asList("D3","F6")));
			gamePlayer4.addSalvo(salvo5);
			salvoRepository.save(salvo5);



			Salvo salvo6 = new Salvo(2, new ArrayList<>(Arrays.asList("J7","D2")));
			gamePlayer5.addSalvo(salvo6);
			salvoRepository.save(salvo6);


			Salvo salvo7 = new Salvo(2, new ArrayList<>(Arrays.asList("J7","D2")));
			gamePlayer7.addSalvo(salvo7);
			salvoRepository.save(salvo7);

			Salvo salvo8 = new Salvo(2, new ArrayList<>(Arrays.asList("J7","D2")));
			gamePlayer8.addSalvo(salvo8);
			salvoRepository.save(salvo8);

			//-------------------------------------scores-------------------------------------------------------

			Score score1 = new Score(1.0,date1hLater,game1,p1);
			Score score3 = new Score(0.0,date1hLater,game1,p2);
			scoreRepository.save(score3);
			scoreRepository.save(score1);
			//Date secondFinish = Date.from(date1hLater.toInstant().plusSeconds(1800));
			Score score2 = new Score(0.5,date2hLater,game2,p2);
			scoreRepository.save(score2);
			Score score4 = new Score(0.5,date2hLater,game2,p5);
			scoreRepository.save(score4);
			Score score5 = new Score(1.0,date1hLater,game3,p3);
			scoreRepository.save(score5);
			Score score6 = new Score(0.0,date1hLater,game3,p2);
			scoreRepository.save(score6);
			Score score7 = new Score(1.0,date1hLater,game4,p1);
			scoreRepository.save(score7);

		};
	}
}
