package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {

        //When
        //Then
        assertEquals(8., calculator.add(4.5, 3.5));
        assertEquals(3.5, calculator.sub(7.7, 4.2));
        assertEquals(7., calculator.mul(3.5, 2));
        assertEquals(1.75, calculator.div(3.5, 2));
    }
}
