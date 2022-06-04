package com.kodilla.good.patterns.food2door;

public interface OrderCompleted {

    boolean process(int quantity, String productType);

    String getName();
}
