package com.kodilla.good.patterns.flights;

import java.util.List;

public interface SearchingFlight {

    List<Flight> searchFlight(List<Flight> flights, Flight flight);
}
