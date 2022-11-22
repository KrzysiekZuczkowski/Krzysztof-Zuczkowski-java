package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    void testBasicPizzaOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Dough and tomato sauce with cheese", description);
    }

    @Test
    void testBigPizzaExtraCheeseOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BigPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(29), calculatedCost);
    }

    @Test
    void testBigPizzaExtraCheeseOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BigPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Big size\n" +
                "Dough and tomato sauce with cheese" +
                "\n+ extra cheese", description);
    }

    @Test
    void testBigPizzaExtraCheeseMushroomsChickenBreastGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BigPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        theOrder = new MushroomsPizzaOrderDecorator(theOrder);
        theOrder = new ChickenBreastPizzaOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(38), calculatedCost);
    }

    @Test
    void testBigPizzaExtraCheeseMushroomsChickenBreastOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BigPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        theOrder = new MushroomsPizzaOrderDecorator(theOrder);
        theOrder = new ChickenBreastPizzaOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Big size\n" +
                "Dough and tomato sauce with cheese" +
                "\n+ extra cheese" +
                "\n+ mushrooms" +
                "\n+ extra chicken breast", description);
    }

    @Test
    void testMediumPizzaExtraCheeseMushroomsChickenBreastGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MediumPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        theOrder = new MushroomsPizzaOrderDecorator(theOrder);
        theOrder = new ChickenBreastPizzaOrderDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(38 - 5), calculatedCost);
    }

    @Test
    void testMediumPizzaExtraCheeseMushroomsChickenBreastOrderDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MediumPizzaOrderDecorator(theOrder);
        theOrder = new ExtraCheesePizzaOrderDecorator(theOrder);
        theOrder = new MushroomsPizzaOrderDecorator(theOrder);
        theOrder = new ChickenBreastPizzaOrderDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Medium size\n" +
                "Dough and tomato sauce with cheese" +
                "\n+ extra cheese" +
                "\n+ mushrooms" +
                "\n+ extra chicken breast", description);
    }
}
