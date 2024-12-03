package com.GamePro;
import java.util.Scanner;
/*
Author: Raghul_S_M
Developed on: 28-11-24
Modified on:
Reviewed by:
Reviewed on:
*/
public class CarRental {

    // Method to handle the car rental process
    public static void rentCar(boolean isLoginSuccessful) {
    	if(isLoginSuccessful) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of Car objects
        Car car1 = new Car("Toyota Camry", 3500);
        Car car2 = new Car("Honda Civic", 5000);
        Car car3 = new Car("BMW 5 Series", 10000);

        // Display car options
        System.out.println("Welcome to the Car Rental System!");
        System.out.println("Available Cars:");
        System.out.println("1. " + car1.getCarModel() + " - Rs" + car1.getRentalPricePerDay() + " per day");
        System.out.println("2. " + car2.getCarModel() + " - Rs" + car2.getRentalPricePerDay() + " per day");
        System.out.println("3. " + car3.getCarModel() + " - Rs" + car3.getRentalPricePerDay() + " per day");
        
        // Ask the user to choose a car
        System.out.print("Enter the number corresponding to your choice of car (1-3): ");
        int carChoice = scanner.nextInt();

        // Get the rental duration from the user
        System.out.print("Enter the number of rental days: ");
        int rentalDays = scanner.nextInt();

        // Select the car based on the user's choice
        Car selectedCar = null;
        switch (carChoice) {
            case 1:
                selectedCar = car1;
                break;
            case 2:
                selectedCar = car2;
                break;
            case 3:
                selectedCar = car3;
                break;
            default:
                System.out.println("Invalid choice.");
                
        }
        

        // Calculate the total rental cost
        double totalCost = selectedCar.calculateRentalCost(rentalDays);

        // Display the rental details
        System.out.println("\nRental Details:");
        System.out.println("Car Model: " + selectedCar.getCarModel());
        System.out.println("Rental Price per Day: Rs" + selectedCar.getRentalPricePerDay());
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Total Rental Cost: Rs" + totalCost);
        
    	}
    	else {
    		System.out.println("----------------Login to Rent---------------");
    		RentalApplication.main(null);
    	}
    }
    

}

