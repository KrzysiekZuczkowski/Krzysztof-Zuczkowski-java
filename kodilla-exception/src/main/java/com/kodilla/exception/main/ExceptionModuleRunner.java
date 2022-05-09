package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightToFind;
import com.kodilla.exception.test.RouteNotFoundException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

        FlightToFind toAirport = new FlightToFind();
        Flight flight = new Flight("Berlin", "Tokyo");


        try {
            if(toAirport.findFlight(flight))
                System.out.println("There is a connection to " +
                        flight.getDepartureAirport() + ".");
            else
                System.out.println("Connection to this airport temporarily canceled.");
        }catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
