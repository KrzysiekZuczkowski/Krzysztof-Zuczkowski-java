package com.kodilla.good.patterns.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve(int quantity) {

        return new OrderRequest(quantity, "eggs");
    }
}
