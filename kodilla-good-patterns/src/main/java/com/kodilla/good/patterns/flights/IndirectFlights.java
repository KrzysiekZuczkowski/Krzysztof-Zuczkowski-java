package com.kodilla.good.patterns.flights;

public class IndirectFlights extends Flight {

    private String indirectCity;

    public IndirectFlights(Flight flight, String indirectCity) {
        super(flight.getDeparture(), flight.getArrival());
        this.indirectCity = indirectCity;
    }

    @Override
    public String toString() {
        return "IndirectFlights{" +
                "departure='" + getDeparture() + '\'' +
                ", indirectCity='" + indirectCity + '\'' +
                ", arrival='" + getArrival() + '\'' +
                '}';
    }
}
