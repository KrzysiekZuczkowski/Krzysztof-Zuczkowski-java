package com.kodilla.rps.game;

import java.util.Random;
import java.util.Scanner;

public class Computer implements  RPS {

    private  String name = "Computer";

    public int makeAChoice(Scanner sc) {
        Random choice = new Random();
        return choice.nextInt(3);
    }

    @Override
    public String toString() {
        return "name '" + name + '\'';
    }
}
