package com.kodilla.good.patterns.food2door;

public class CompletedOrder {

    private OrderCompleted orderCompleted;

    public CompletedOrder(OrderCompleted orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public OrderDto complete(OrderRequest orderRequest) {
        boolean isCompleted = orderCompleted.process(orderRequest.getQuantity(),
                orderRequest.getProductType());

        return isCompleted ? new OrderDto(orderCompleted.getName(), true) :
                new OrderDto(orderCompleted.getName(), false);
    }
}
