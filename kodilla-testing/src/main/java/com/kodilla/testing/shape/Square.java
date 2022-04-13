package com.kodilla.testing.shape;

public class Square implements Shape{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    public double getField() {
        return getSide() * getSide();
    }

    @Override
    public String toString() {
        return getShapeName() + " { side = " +
                getSide() + " field = " +
                getField() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        return Double.compare(square.getSide(), getSide()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getSide());
        return (int) (temp ^ (temp >>> 32));
    }

    public double getSide() {
        return side;
    }
}
