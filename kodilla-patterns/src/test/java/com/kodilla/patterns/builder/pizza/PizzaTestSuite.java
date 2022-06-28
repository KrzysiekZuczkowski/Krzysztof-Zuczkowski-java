package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .bottom("Thin")
                .ingredient("Mushrooms")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Onion")
                .build();

        System.out.println(pizza);
        //When
        int howManyIngredients = pizza.getIngredients().size();

        //Then
        assertEquals(3, howManyIngredients);

    }
}