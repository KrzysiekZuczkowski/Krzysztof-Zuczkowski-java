package com.kodilla.testing.weather.stub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageForecast() {
        double sum = 0;
        Map<String, Double> temperaturesMap = temperatures.getTemperatures();

        for(Map.Entry<String, Double> temperature : temperaturesMap.entrySet())
            sum += temperature.getValue();


        return sum / temperaturesMap.size();
    }

    public double calculateMedianForecast() {
        Double[] temperaturesArray = temperatures.getTemperatures().values().toArray(new Double[0]);
        if(temperaturesArray.length == 0)
            return 0.0;

        int halfLength = temperaturesArray.length / 2;

        Arrays.sort(temperaturesArray);
        if(temperaturesArray.length % 2 == 0)
            return (temperaturesArray[halfLength - 1] +
                            temperaturesArray[halfLength]) / 2;

        return temperaturesArray[halfLength];
    }
}
