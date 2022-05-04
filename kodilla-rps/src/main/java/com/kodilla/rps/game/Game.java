package com.kodilla.rps.game;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Game {

    private Player playerOne;
    private Player playerTwo;
    private int playerOneScores;
    private int playerTwoScores;
    private int numberOfWins;

    private final static String[] gameKeys = new String[]
                        {"Rock", "Paper", "Scissors", "x", "n"};

    public Game(Scanner sc) {
        playerOne = new Player(new Person(sc));
        playerTwo = new Player(new Computer());
        setNumberOfWins(askForTheNumberOfWins(sc));
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int askForTheNumberOfWins(Scanner sc) {
        System.out.println("Please enter a number of wins.");
        return sc.nextInt();
    }

    protected abstract void endGame(Scanner sc);

    public void processGame(Scanner sc) {
        playerOne.addAChoice(sc);
        playerTwo.addAChoice(sc);
        int playerOneChoice =
                playerOne.getPlayerChoices().get(playerOne.getPlayerChoices().size() - 1);
        int playerTwoChoice =
                playerTwo.getPlayerChoices().get(playerTwo.getPlayerChoices().size() - 1);
        showPlayersChoices(playerOneChoice, playerTwoChoice);
        showScoresOfTheRound(playerOneChoice, playerTwoChoice);
        showSummary();
    }

    public void showPlayersChoices(int playerOne, int playerTwo) {
        System.out.println(this.playerOne.getPlayer() + " chose " + gameKeys[playerOne]);
        System.out.println(this.playerTwo.getPlayer() + " chose " + gameKeys[playerTwo]);
    }

    public void showScoresOfTheRound(int playerOne, int playerTwo) {
        int playerOneTemporaryScores = 0;
        int playerTwoTemporaryScores = 0;
        if(playerOne == playerTwo) {
            increasePlayerOneScores();
            increasePlayerTwoScores();
            System.out.println("The round ends in a draw.");
        }
        else {
            if (playerOne == 0 && playerTwo == 2)
                playerOneTemporaryScores++;
            else if (playerOne == 1 && playerTwo == 0)
                playerOneTemporaryScores++;
            else if (playerOne == 2 && playerTwo == 1)
                playerOneTemporaryScores++;
            else
                playerTwoTemporaryScores++;

            if (playerOneTemporaryScores > playerTwoTemporaryScores) {
                increasePlayerOneScores();
                System.out.println("this round win " + this.playerOne);
            } else {
                increasePlayerTwoScores();
                System.out.println("this round win " + this.playerTwo);
            }
        }
    }

    public void increasePlayerOneScores() {
        playerOneScores++;
    }

    public void increasePlayerTwoScores() {
        playerTwoScores++;
    }

    public void showSummary() {
        System.out.println(playerOne + ", scores = " + playerOneScores +
                "  |  " + playerTwo + ", scores = " + playerTwoScores + '\n');
    }

    public void showInfo() {
        String theResultStringOfKeys = IntStream.range(0, 3)
                .mapToObj(n -> "key " + (n + 1) + " play " + gameKeys[n])
                .collect(Collectors.joining(", \n", "Game keys \n<< ", ""));

        theResultStringOfKeys += IntStream.range(3, 5)
                .mapToObj(n -> gameKeys[n])
                .map(s -> {
                            if (s.equals("x"))
                                return ",\nkey " + s + " quit";
                            else
                                return "key " + s + " new game";
                        }
                )
                .collect(Collectors.joining(", \n", "" , " >>"));

        System.out.println(theResultStringOfKeys);
    }

    public void setPlayerOneScores(int n) {
        playerOneScores = n;
    }

    public void setPlayerTwoScores(int n) {
        playerTwoScores = n;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getPlayerOneScores() {
        return playerOneScores;
    }

    public int getPlayerTwoScores() {
        return playerTwoScores;
    }
}
