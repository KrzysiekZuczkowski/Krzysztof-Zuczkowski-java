package com.kodilla.good.patterns.flights;

import java.util.List;

public class SearchingFlightProcessor {

    private SearchingFlight searchingFlights;

    public SearchingFlightProcessor(SearchingFlight searchingFlights) {
        this.searchingFlights = searchingFlights;
    }

    public void search(List<Flight> flights, Flight flight) {
        searchingFlights.searchFlight(flights, flight)
                .forEach(System.out :: println);

        System.out.println();
    }
}
