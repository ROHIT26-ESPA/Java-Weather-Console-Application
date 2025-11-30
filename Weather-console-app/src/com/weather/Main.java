package com.weather;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        boolean exit = false;

        System.out.println("====================================");
        System.out.println("        Simple Java Weather App     ");
        System.out.println("====================================");

        while (!exit) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> handleCheckWeather();
                case 2 -> handleListCities();
                case 0 -> {
                    System.out.println("Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Check weather for a city");
        System.out.println("2. List supported cities");
        System.out.println("0. Exit");
    }

    private static void handleCheckWeather() {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();

        if (city.isEmpty()) {
            System.out.println("City name cannot be empty.");
            return;
        }

        WeatherInfo info = weatherService.getWeatherForCity(city);
        if (info == null) {
            System.out.println("Sorry, weather data for \"" + city + "\" is not available.");
            System.out.println("Tip: Use option 2 to see supported city names.");
        } else {
            weatherService.printWeatherWithBothUnits(info);
        }
    }

    private static void handleListCities() {
        System.out.println("\nSupported Cities:");
        List<String> cities = weatherService.getSupportedCities();
        for (String city : cities) {
            System.out.println("- " + city);
        }
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
