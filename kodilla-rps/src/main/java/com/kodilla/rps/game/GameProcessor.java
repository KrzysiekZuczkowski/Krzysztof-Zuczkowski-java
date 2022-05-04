package com.kodilla.rps.game;

import java.util.Scanner;

public class GameProcessor extends Game {

    private boolean end;

    public GameProcessor(Scanner sc) {
        super(sc);
    }

    public void run(Scanner sc) {
        showInfo();

        while (!end) {
            while (getPlayerOneScores() < this.getNumberOfWins() &&
                        getPlayerTwoScores() < this.getNumberOfWins()) {
                processGame(sc);
            }
            endGame(sc);
        }
    }

    protected void endGame(Scanner sc) {
        if(getPlayerOneScores() > getPlayerTwoScores())
            System.out.println("Win " + getPlayerOne());
        else if(getPlayerOneScores()== getPlayerTwoScores())
            System.out.println("Draw!!!");
        else
            System.out.println("Win " + getPlayerTwo());

        System.out.println("Do you want to quit? Press x.\n" +
                "Do you want to play again? Press n.");
            String s = sc.next();
            if(s.equals("x"))
                end = true;
            else if(s.equals("n")) {
                    setPlayerOneScores(0);
                    setPlayerTwoScores(0);
            }
    }
}
