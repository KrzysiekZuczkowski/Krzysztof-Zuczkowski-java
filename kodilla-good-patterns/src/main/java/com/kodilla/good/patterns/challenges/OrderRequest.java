package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private LocalDateTime orderFrom;
    private LocalDateTime orderTo;

    public OrderRequest(final User user,
                        final LocalDateTime orderFrom,
                        final LocalDateTime orderTo) {

        this.user = user;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderFrom() {
        return orderFrom;
    }

    public LocalDateTime getOrderTo() {
        return orderTo;
    }
}
