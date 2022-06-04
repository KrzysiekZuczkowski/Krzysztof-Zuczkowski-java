package com.kodilla.good.patterns.food2door;

public class PromotionTake10Get11 implements CalculatePromotion {

    public int calculate(int quantity) {
        int free = quantity / 10;
        return quantity + free;
    }

}
