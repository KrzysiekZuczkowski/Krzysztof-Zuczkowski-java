package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FlightsRetriever {

    public List<Flight> retrieve() {
        List<Flight> flights = new ArrayList<>();
        String[] cities = new String[]{"Gdansk", "Warszawa", "Warszawa",
                "Poznan", "Wroclaw", "Krakow"};
        Random random = new Random();

        for(String city : cities) {
            for(int i = 0; i < 3; i++) {
                int index = random.nextInt(cities.length);
                flights.add(new Flight(city, cities[index]));
            }
        }

        return flights.stream()
                .filter(flight -> !flight.getDeparture().equals(flight.getArrival()))
                .collect(Collectors.toList());
    }
}
