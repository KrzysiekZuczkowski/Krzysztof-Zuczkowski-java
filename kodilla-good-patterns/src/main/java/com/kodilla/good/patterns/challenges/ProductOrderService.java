package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(final User user,
                         final LocalDateTime orderFrom,
                         final LocalDateTime orderTo) {

        System.out.println("Order for: { " + user +
                ", ordering: " + orderFrom.toString() +
                ", completed: " + orderTo.toString() + " }");

        return true;
    }
}
