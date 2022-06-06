package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.stream.Collectors;

public class SearchingAllFlightsFrom implements SearchingFlight {

    @Override
    public List<Flight> searchFlight(List<Flight> flights, Flight flight) {
        return flights.stream()
                .filter(f -> f.getDeparture().equals(flight.getDeparture()))
                .collect(Collectors.toList());
    }
}
