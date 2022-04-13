package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return  this.getClass().getSimpleName();
    }

    public double getField() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public String toString() {
        return getShapeName() + " { radius = " +
                getRadius() + " field = " +
                getField() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getRadius());
        return (int) (temp ^ (temp >>> 32));
    }

    public double getRadius() {
        return radius;
    }
}
