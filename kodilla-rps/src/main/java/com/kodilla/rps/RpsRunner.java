package com.kodilla.rps;

import com.kodilla.rps.game.GameProcessor;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        new GameProcessor(sc).run(sc);
        sc.close();
    }
}
