package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements OrderCompleted{

    private String name = getClass().getSimpleName();
    private CalculatePromotion promotion;

    public ExtraFoodShop() {

    }

    public ExtraFoodShop(CalculatePromotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public boolean process(int quantity, String productType) {
        System.out.println(name + " has completed the order, supplying: " +
                (promotion != null ? promotion.calculate(quantity) : quantity) +
                " " + productType + '.' + '\n');

        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
