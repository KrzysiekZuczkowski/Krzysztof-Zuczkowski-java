package com.kodilla.rps.game;

import java.util.Scanner;

public class Person implements RPS {

    private String name;

    public Person(Scanner sc) {
        System.out.println("Please enter player name.");
        name = sc.next();
    }

    public int makeAChoice(Scanner sc) {
        System.out.println("Please enter a number: 1 - 'Rock', " +
                "2 - 'Paper', 3 - 'Scissors'.");
        int choice = sc.nextInt();
        while(choice != 1 && choice != 2 && choice != 3) {
            choice = sc.nextInt();
        }
        return choice - 1;
    }

    @Override
    public String toString() {
        return "name '" + name + '\'';
    }
}
