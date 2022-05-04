package com.kodilla.rps.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private RPS player;
    private List<Integer> playerChoices = new ArrayList<>();

    public Player(RPS player) {
        this.player = player;
    }

    public void addAChoice(Scanner sc) {
        playerChoices.add(player.makeAChoice(sc));
    }

    @Override
    public String toString() {
          return "player " + player;
    }

    public RPS getPlayer() {
        return player;
    }

    public List<Integer> getPlayerChoices() {
        return playerChoices;
    }
}
