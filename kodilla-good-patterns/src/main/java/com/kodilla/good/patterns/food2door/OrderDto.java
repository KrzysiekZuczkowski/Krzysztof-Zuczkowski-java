package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.challenges.User;

public class OrderDto {

    private String supplierName;
    private boolean isCompleted;

    public OrderDto(String supplierName, boolean isCompleted) {
        this.supplierName = supplierName;
        this.isCompleted = isCompleted;
    }
}
