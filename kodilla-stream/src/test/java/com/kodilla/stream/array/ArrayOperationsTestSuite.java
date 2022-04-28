package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[20];
        Random theGenerator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = theGenerator.nextInt(100);

        //When
        double result = ArrayOperations.getAverage(numbers);
        int sumOfNumbers = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .sum();

        //Then
        assertEquals(sumOfNumbers / (double) numbers.length, result, 0.001);
    }
}

