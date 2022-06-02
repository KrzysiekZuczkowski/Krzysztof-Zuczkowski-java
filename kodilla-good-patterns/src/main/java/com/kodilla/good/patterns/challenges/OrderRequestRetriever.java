package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("John", "Wekl");

        LocalDateTime orderFrom = LocalDateTime.of(2017, 8, 1, 12, 0);
        LocalDateTime orderTo = LocalDateTime.of(2017, 8, 10, 12, 0);

        return new OrderRequest(user, orderFrom, orderTo);
    }
}
