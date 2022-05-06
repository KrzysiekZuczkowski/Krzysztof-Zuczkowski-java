package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        Object e1 = null;
        double result = 0.;

        try {
            result = firstChallenge.divide(3, 0);
        }catch(ArithmeticException e) {
            System.out.println("Something went wrong! Error: " + e);
            e1 = e;
        }finally {
            if(e1 != null)
                System.out.println("The second argument is zero, it cannot be divided.");
        }
        if(e1 == null)
            System.out.println(result) ;
    }
}
