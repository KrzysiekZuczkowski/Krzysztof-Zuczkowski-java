package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BigPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public BigPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return "Big size\n" + super.getDescription();
    }
}
