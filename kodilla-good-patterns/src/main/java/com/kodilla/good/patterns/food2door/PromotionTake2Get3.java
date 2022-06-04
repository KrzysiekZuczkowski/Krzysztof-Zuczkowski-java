package com.kodilla.good.patterns.food2door;

public class PromotionTake2Get3 implements CalculatePromotion {

    public int calculate(int quantity) {
        int free = quantity / 2;
        return quantity + free;
    }
}
