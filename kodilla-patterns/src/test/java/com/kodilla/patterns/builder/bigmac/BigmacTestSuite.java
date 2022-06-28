package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("standard")
                .sauce("standard")
                .ingredient("onion")
                .burgers(2)
                .ingredient("cheese")
                .ingredient("cucumber")
                .ingredient("mushrooms")
                .build();

        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(4, howManyIngredients);
        assertEquals(2, bigmac.getBurgers());
    }
}
