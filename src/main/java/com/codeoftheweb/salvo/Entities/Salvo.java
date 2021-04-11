package com.codeoftheweb.salvo.Entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salvo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    Long id;
    private int turn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;
    @ElementCollection
    @Column(name="salvoLocation")
    private List<String> SalvoLocations = new ArrayList<>();


    public Salvo() {
    }

    public Salvo(int turn, List<String> salvoLocations) {
        this.turn = turn;
        SalvoLocations = salvoLocations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public List<String> getSalvoLocations() {
        return SalvoLocations;
    }

    public void setSalvos(List<String> salvo) {
        SalvoLocations = salvo;
    }

    @Override
    public String toString() {
        return "Salvo{" +
                "id=" + id +
                ", turn=" + turn +
                ", gamePlayer=" + gamePlayer +
                ", SalvoLocations=" + SalvoLocations +
                '}';
    }
}
