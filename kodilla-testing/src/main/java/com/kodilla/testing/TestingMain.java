package com.kodilla.testing;

import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TestingMain {

    public static void main(String[] args) {

        ShapeCollector shapes = new ShapeCollector();

        Triangle tri = new Triangle(3, 4);
        System.out.println(tri);
        System.out.println(new Square(2));
        System.out.println(new Circle(1));

        shapes.addFigure(tri);
        shapes.addFigure(new Square(3));
        shapes.addFigure(new Circle(1));

        System.out.println(shapes.showFigures());
    }
}
