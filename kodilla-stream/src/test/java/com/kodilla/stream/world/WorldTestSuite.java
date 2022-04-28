package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europa = new Continent();
        Continent africa = new Continent();
        Continent asia = new Continent();
        //Creates European countries
        Country poland = new Country("Poland", "38456234");
        Country germany = new Country("Germany", "78956121");
        Country england = new Country("England", "60783456");
        Country france = new Country("France", "80343026");
        //Creates African countries
        Country egypt = new Country("Egypt", "100345933");
        Country kenya = new Country("Kenya", "65209431");
        Country ethiopia = new Country("Ethiopia", "90734104");
        Country sudan = new Country("Sudan", "4056042");
        //Create Asian countries
        Country  china = new Country("China", "4847760371");
        Country  japan = new Country("Japan", "100430981");
        Country  india = new Country("India", "2960831254");
        Country  indonesia = new Country("Indonesia", "250744351");


        europa.addCountry(poland);
        europa.addCountry(germany);
        europa.addCountry(england);
        europa.addCountry(france);



        for (Country country : Arrays.asList(poland, germany, england, france)) {
            europa.addCountry(country);
        }

        for (Country country : Arrays.asList(egypt, kenya, ethiopia, sudan)) {
            africa.addCountry(country);
        }

        for (Country country : Arrays.asList(china, japan, india, indonesia)) {
            asia.addCountry(country);
        }

        for(Continent continent : Arrays.asList(europa, africa, asia))
            world.addContinent(continent);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();
        BigDecimal expectedPeople = new BigDecimal("8678651304");

        //Then
        assertEquals(expectedPeople, totalPeople);
        assertEquals(3, world.getContinents().size());
        assertEquals(4, europa.getCountries().size());
        assertEquals(4, africa.getCountries().size());
        assertEquals(4, asia.getCountries().size());
        assertTrue(europa.getCountriesNames().contains("Poland"));
        assertFalse(asia.getCountriesNames().contains("Poland"));
    }
}
