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

    @Test
    void setStaticNestedObjectTeat() {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);
    }
}

    class OuterClass {

        String outerField = "Outer field";
        static String staticOuterField = "Static outer field";

        class InnerClass {
            void accessMembers() {
                System.out.println(outerField);
                System.out.println(staticOuterField);
            }
        }

        static class StaticNestedClass {
            void accessMembers(OuterClass outer) {
                // Compiler error: Cannot make a static reference to the non-static
                //     field outerField
                // System.out.println(outerField);
                System.out.println(outer.outerField);
                System.out.println(staticOuterField);
            }
    }
}