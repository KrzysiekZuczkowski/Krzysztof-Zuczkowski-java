package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderRepository implements  OrderRepository{


    @Override
    public boolean createOrder(User user, LocalDateTime orderFrom, LocalDateTime orderTo) {
        System.out.println("We created record for: { " + user +
                ", ordering: " + orderFrom.toString() +
                ", completed: " + orderTo.toString() + " }");

        return true;
    }
}
