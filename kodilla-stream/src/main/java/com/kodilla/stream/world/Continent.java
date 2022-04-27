package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Continent {

    private final Set<Country> countries = new HashSet<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public Set<String> getCountriesNames() {
        return countries.stream()
                .map(country -> country.getCountryName())
                .collect(Collectors.toSet());
    }

    public Set<Country> getCountries() {
        return countries;
    }
}
