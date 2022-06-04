package com.kodilla.good.patterns.food2door;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve(8);
        CompletedOrder completedOrder = new CompletedOrder(new ExtraFoodShop());
        completedOrder.complete(orderRequest);

        orderRequest = orderRequestRetriever.retrieve(5);
        completedOrder = new CompletedOrder(new ExtraFoodShop(new PromotionTake2Get3()));
        completedOrder.complete(orderRequest);

        orderRequest = orderRequestRetriever.retrieve(20);
        completedOrder = new CompletedOrder(new HealthyShop(new PromotionTake10Get11()));
        completedOrder.complete(orderRequest);

        orderRequest = orderRequestRetriever.retrieve(10);
        completedOrder = new CompletedOrder(new HealthyShop(new PromotionGetExtraPoints()));
        completedOrder.complete(orderRequest);
    }
}
