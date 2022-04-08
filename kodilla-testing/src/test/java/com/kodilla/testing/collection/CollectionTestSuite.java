package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end\n");
    }

    @DisplayName("When exterminate method is called from OddNumberExterminator " +
            "class with an argument as emptyList " +
            "then this method should return an empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResul = new ArrayList<>();

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Testing exterminate(emptyList)");
        //Then
        Assertions.assertIterableEquals(expectedResul, result);
    }

    @DisplayName("When exterminate method is called from OddNumberExterminator " +
                "class with an argument as normalList " +
                "then this method should return a list of even numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> expectedResul = new ArrayList<>(asList(2, 4));

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(
                                new ArrayList<>(asList(1, 2, 3, 4, 5)));
        System.out.println("Testing exterminate(normalList)");

        //Then
        Assertions.assertIterableEquals(expectedResul, result);
    }
}
