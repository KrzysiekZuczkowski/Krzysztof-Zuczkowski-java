package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {

        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUserName();

        if(result.equals("theForumUser"))
            System.out.println("test ok");
        else
            System.out.println("Error!");

        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator();
        int a = 7, b = 4;
        int addResult = a + b, subtractResult = a - b;

        System.out.println("------------ 1 -----------");
        if(calculator.add(a, b) == addResult)
            System.out.println("test ok");
        else
            System.out.println("Error!");

        System.out.println("------------ 2 -----------");
        if(calculator.subtract(a, b) == subtractResult)
            System.out.println("test ok");
        else
            System.out.println("Error!");
    }
}
