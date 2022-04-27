package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String countryName;
    private final BigDecimal peopleQuantity;

    public Country(String countryName, String peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = new BigDecimal(peopleQuantity);
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null)
            return false;
        return getPeopleQuantity() != null ? getPeopleQuantity().equals(country.getPeopleQuantity()) : country.getPeopleQuantity() == null;
    }

    @Override
    public int hashCode() {
        return getPeopleQuantity() != null ? getPeopleQuantity().hashCode() : 0;
    }
}
