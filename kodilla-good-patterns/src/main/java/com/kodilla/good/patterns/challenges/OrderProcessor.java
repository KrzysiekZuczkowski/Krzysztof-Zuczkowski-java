package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService,
                          OrderService orderService,
                          OrderRepository orderRepository) {

        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(),
                orderRequest.getOrderFrom(),
                orderRequest.getOrderTo());

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(),
                    orderRequest.getOrderFrom(),
                    orderRequest.getOrderTo());

            return new OrderDto(orderRequest.getUser(), true);
        }

        return new OrderDto(orderRequest.getUser(), false);
    }
}
