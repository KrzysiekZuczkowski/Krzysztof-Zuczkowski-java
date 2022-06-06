package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchingFlightsThroughAnotherCity implements SearchingFlight {

    @Override
    public List<Flight> searchFlight(List<Flight> flights, Flight flight) {
        List<Flight> tempFlights;
        List<Flight> indirectFlights = new ArrayList<>();
        SearchingFlight searchingFrom = new SearchingAllFlightsFrom();

        tempFlights = new ArrayList<>(flights.stream()
                .filter(f -> !f.equals(flight))
                .collect(Collectors.toSet()));

        searchingFrom.searchFlight(tempFlights, flight).stream()
                .map(Flight :: swapDeparturesWithArrivals)
                .forEach(f -> {
                            searchingFrom.searchFlight(tempFlights, f).stream()
                                    .filter(f1 -> f1.getArrival().equals(flight.getArrival()))
                                    .forEach(f1 -> indirectFlights.add
                                            (new IndirectFlights(flight, f1.getDeparture())));
                });

        return indirectFlights;
    }
}
