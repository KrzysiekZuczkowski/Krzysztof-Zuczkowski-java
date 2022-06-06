package com.kodilla.good.patterns.flights;

public class Flight {

    private String departure;
    private String arrival;

    public Flight(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (getDeparture() != null ? !getDeparture().equals(flight.getDeparture()) : flight.getDeparture() != null)
            return false;
        return getArrival() != null ? getArrival().equals(flight.getArrival()) : flight.getArrival() == null;
    }

    @Override
    public int hashCode() {
        int result = getDeparture() != null ? getDeparture().hashCode() : 0;
        result = 31 * result + (getArrival() != null ? getArrival().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                '}';
    }

    public Flight swapDeparturesWithArrivals() {
        String temp = departure;
        departure = arrival;
        arrival = temp;

        return this;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
