package com.kodilla.good.patterns.food2door;

public class OrderRequest {

    private int quantity;
    private String productType;

    public OrderRequest(int quantity, String productType) {
        this.quantity = quantity;
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductType() {
        return productType;
    }
}
