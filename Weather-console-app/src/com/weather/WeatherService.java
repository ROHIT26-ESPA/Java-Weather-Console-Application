package com.weather;

import java.util.*;

public class WeatherService {

    private Map<String, WeatherInfo> weatherData;

    public WeatherService() {
        weatherData = new HashMap<>();
        seedData();
    }

    private void seedData() {
        // You can customize these cities and values
        addWeather(new WeatherInfo("Mumbai", 32.5, 70, "Sunny"));
        addWeather(new WeatherInfo("Delhi", 29.0, 55, "Partly Cloudy"));
        addWeather(new WeatherInfo("Chennai", 34.2, 75, "Humid"));
        addWeather(new WeatherInfo("Kolkata", 30.8, 68, "Cloudy"));
        addWeather(new WeatherInfo("Bengaluru", 26.4, 60, "Cool and Breezy"));
        addWeather(new WeatherInfo("Hyderabad", 31.1, 58, "Sunny"));
    }

    private void addWeather(WeatherInfo info) {
        weatherData.put(info.getCity().toLowerCase(), info);
    }

    public WeatherInfo getWeatherForCity(String cityName) {
        if (cityName == null) return null;
        return weatherData.get(cityName.toLowerCase());
    }

    public List<String> getSupportedCities() {
        List<String> cities = new ArrayList<>();
        for (WeatherInfo info : weatherData.values()) {
            cities.add(info.getCity());
        }
        Collections.sort(cities);
        return cities;
    }

    public void printWeatherWithBothUnits(WeatherInfo info) {
        System.out.println("\n=== Weather Report ===");
        System.out.println("City: " + info.getCity());
        System.out.println("Condition: " + info.getCondition());
        System.out.println("Humidity: " + info.getHumidity() + "%");
        System.out.println("Temperature: " + String.format("%.1f", info.getTemperatureCelsius()) + "°C");

        double fahrenheit = TemperatureConverter.celsiusToFahrenheit(info.getTemperatureCelsius());
        System.out.println("Temperature: " + String.format("%.1f", fahrenheit) + "°F");
    }
}
