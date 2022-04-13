package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testAddFigure() {
        //Given
        Shape circle = new Circle(3.5);
        ShapeCollector shapes = new ShapeCollector();

        //When
        shapes.addFigure(circle);

        //Then
        assertEquals(1, shapes.getShapesQuantity());
    }

    @Test
    void testAddNullFigure() {
        //Given
        Shape square = null;
        ShapeCollector shapes = new ShapeCollector();

        //When
        shapes.addFigure(square);

        //Then
        assertEquals(0, shapes.getShapesQuantity());
    }

    @Test
    void testRemoveFigureNotExisting() {
        //Given
        Shape triangle = new Triangle(2.5, 2);
        ShapeCollector shapes = new ShapeCollector();

        //When
        boolean result =  shapes.removeFigure(triangle);

        //Then
        assertFalse(result);
    }

    @Test
    void testRemoveFigure() {
        //Given
        Shape square = new Square(3);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(square);

        //When
        boolean result = shapes.removeFigure(square);

        //Then
        assertTrue(result);
        assertEquals(0, shapes.getShapesQuantity());
    }

    @Test
    void testGetFigureIndexOutOfBoundsNegative() {
        //Given
        Shape circle = new Circle(5.5);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(circle);

        //When
        Shape retrievedShape = shapes.getFigure(-1);

        //Then
        assertNull(retrievedShape);
    }

    @Test
    void testGetFigureIndexOutOfBounds() {
        //Given
        Shape circle = new Circle(5.5);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(circle);

        //When
        Shape retrievedShape = shapes.getFigure(1);

        //Then
        assertNull(retrievedShape);
    }

    @Test
    void testGetFigure() {
        //Given
        Shape square = new Square(5.5);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(new Triangle(2.4, 3.5));
        shapes.addFigure(square);

        //When
        Shape retrievedShape = shapes.getFigure(1);

        //Then
        assertEquals(square, retrievedShape);
    }

    @Test
    void testShowFiguresEmptyList() {
        //Given
        ShapeCollector shapes = new ShapeCollector();
        String expectedResult = "";

        //When
        String result = shapes.showFigures();

        //Then
        assertEquals(expectedResult, result);
    }

    @Test
    void testShowFigures() {
        //Given
        Shape square = new Square(2);
        Shape triangle = new Triangle(3, 4);
        ShapeCollector shapes = new ShapeCollector();
        shapes.addFigure(square);
        shapes.addFigure(triangle);
        String expectedResult = "Square { side = 2.0 field = 4.0 }, " +
                                "Triangle { baseA = 3.0, height = 4.0 field = 6.0 }";

        //When
        String result = shapes.showFigures();

        //Then
        assertEquals(expectedResult, result);
    }
}
