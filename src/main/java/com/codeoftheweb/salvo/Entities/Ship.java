package com.codeoftheweb.salvo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;
    @ElementCollection
    @Column(name="shipLocation")
    private List<String> ShipLocations = new ArrayList<>();

    public Ship() {
    }

    public Ship(String type, List<String> shipLocations) {
        this.type = type;
        ShipLocations = shipLocations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
@JsonIgnore
    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public List<String> getShipLocations() {
        return ShipLocations;
    }

    public void setShipLocations(List<String> shipLocations) {
        ShipLocations = shipLocations;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", gamePlayer=" + gamePlayer +
                ", ShipLocations=" + ShipLocations +
                '}';
    }
}
