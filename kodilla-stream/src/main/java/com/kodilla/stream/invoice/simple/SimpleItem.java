package com.kodilla.stream.invoice.simple;

//item invoice (pozycja faktury)
public final class SimpleItem {

    private final SimpleProduct product;
    private  final double quantity;

    public SimpleItem(final SimpleProduct product, final double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getValue() {
        return product.getProductPrice() * quantity;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
