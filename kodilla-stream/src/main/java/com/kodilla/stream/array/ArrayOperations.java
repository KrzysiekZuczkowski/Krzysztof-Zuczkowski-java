package com.kodilla.stream.array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        String stringOfNumbers = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .mapToObj(n -> n + "")
                .collect(Collectors.joining(", ","Elements of the array\n",""));

        System.out.println(stringOfNumbers);

        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }
}
