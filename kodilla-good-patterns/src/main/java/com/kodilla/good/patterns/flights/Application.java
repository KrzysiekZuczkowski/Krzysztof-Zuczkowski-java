package com.kodilla.good.patterns.flights;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        FlightsRetriever flightsRetriever = new FlightsRetriever();
        List<Flight> flights = flightsRetriever.retrieve();
        Flight flight = new Flight("Warszawa", "Gdansk");

        System.out.println("All flights.");
        flights.forEach(System.out :: println);

        System.out.println("All flights from " + flight.getDeparture() + '.');
        SearchingFlightProcessor processor = new SearchingFlightProcessor(
                new SearchingAllFlightsFrom());
        processor.search(flights, flight);

        System.out.println("All flights to " + flight.getArrival()  + '.');
        processor = new SearchingFlightProcessor(new SearchingAllFlightsTo());
        processor.search(flights, flight);

        System.out.println("All indirect flights from " + flight. getDeparture() +
                " to " + flight.getArrival() + '.');
        processor = new SearchingFlightProcessor(new SearchingFlightsThroughAnotherCity());
        processor.search(flights, flight);
    }
}
