package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        if(shape != null)
            shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if(shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n) {
        if(n < 0 || n > shapes.size() - 1)
            return null;

        return shapes.get(n);
    }

    public String showFigures() {
        if(shapes.size() > 0) {
            int i;
            StringBuilder stringFigures = new StringBuilder();

            for (i = 0; i < shapes.size() - 1; i++)
                stringFigures.append(shapes.get(i)).append(", ");

            stringFigures.append(shapes.get(i));

            return stringFigures.toString();
        }

        return "";
    }

    public int getShapesQuantity() {
        return shapes.size();
    }
}
