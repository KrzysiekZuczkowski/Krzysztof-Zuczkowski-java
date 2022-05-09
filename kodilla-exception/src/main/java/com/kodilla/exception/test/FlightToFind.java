package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightToFind {

    public boolean findFlight(Flight flight) throws RouteNotFoundException{

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("London", true);
        airports.put("Warsaw", true);
        airports.put("New York", false);
        airports.put("Tokyo", false);

        if(!airports.containsKey(flight.getDepartureAirport()))
            throw new RouteNotFoundException("There is no connection to " +
                    flight.getDepartureAirport() + ".");

        return airports.get(flight.getDepartureAirport());
    }
}
