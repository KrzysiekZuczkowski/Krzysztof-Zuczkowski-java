package com.kodilla.good.patterns.food2door;

public class PromotionGetExtraPoints implements  CalculatePromotion {

    public int calculate(int quantity) {
        System.out.println("Ypu got " + quantity + " points!");
        return quantity;
    }
}
