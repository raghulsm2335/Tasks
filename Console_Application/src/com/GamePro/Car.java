package com.GamePro;
/*
Author: Raghul_S_M
Developed on: 28-11-24
Modified on:
Reviewed by:
Reviewed on:
*/
public class Car {
    private String carModel;
    private double rentalPricePerDay;

    // Constructor to initialize car model and rental price per day
    public Car(String carModel, double rentalPricePerDay) {
        this.carModel = carModel;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Getter for car model
    public String getCarModel() {
        return carModel;
    }

    // Getter for rental price per day
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    // Method to calculate the rental cost based on the number of rental days
    public double calculateRentalCost(int rentalDays) {
        return rentalPricePerDay * rentalDays;
    }
}

