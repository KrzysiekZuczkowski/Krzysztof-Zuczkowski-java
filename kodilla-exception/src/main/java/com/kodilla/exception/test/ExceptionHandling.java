package com.kodilla.exception.test;

public class ExceptionHandling {

    public String probablyIWillThrowException(double x, double y) throws ExceptionProbably {
        try {
            return new SecondChallenge().probablyIWillThrowException(x, y);
        }catch(Exception e) {
            System.out.println("Try to change the arguments of the method.");
            throw new ExceptionProbably();
        }finally {
            System.out.println("The argument x should be greater equal 1, and less then 2," +
                    " second argument y should be different then 1.5.");
        }
    }
}