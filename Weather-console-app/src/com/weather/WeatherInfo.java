package com.weather;

public class WeatherInfo {
    private String city;
    private double temperatureCelsius;
    private int humidity;
    private String condition;

    public WeatherInfo(String city, double temperatureCelsius, int humidity, String condition) {
        this.city = city;
        this.temperatureCelsius = temperatureCelsius;
        this.humidity = humidity;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "City: " + city +
                "\nTemperature: " + String.format("%.1f", temperatureCelsius) + "°C" +
                "\nHumidity: " + humidity + "%" +
                "\nCondition: " + condition;
    }
}
