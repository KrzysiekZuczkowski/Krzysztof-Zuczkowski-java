package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double baseA;
    private double height;

    public Triangle(double baseA, double height) {
        this.baseA = baseA;
        this.height = height;
    }

    @Override
    public String toString() {
        return getShapeName() + " { baseA = " +
                baseA + ", height = " + height +
                " field = " + getField() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.getBaseA(), getBaseA()) != 0) return false;
        return Double.compare(triangle.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getBaseA());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    public double getField() {
        return 0.5 * getBaseA() * getHeight();
    }

    public double getBaseA() {
        return baseA;
    }

    public double getHeight() {
        return height;
    }
}
