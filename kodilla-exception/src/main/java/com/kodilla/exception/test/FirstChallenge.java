package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) {
        try {
            return  a / b;
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(b == 0)
                System.out.println("Cannot be divided by the second argument. Must be non-zero");
        }
        return 0;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(3, 0);

        System.out.println(result);
    }
}
