package com.GamePro;
import java.util.Scanner;
/*
Author: Raghul_S_M
Developed on: 28-11-24
Modified on:
Reviewed by:
Reviewed on:
*/
public class RentalApplication {
	
	static boolean isLoginSuccessful;
	
	public static void getStart() {
		System.out.println("Existing user Press 1. New user Press 2. ");
		Scanner scanner = new Scanner(System.in);
		int userStatus=scanner.nextInt();
		
		switch(userStatus) {
		case 1:
			isLoginSuccessful = ExistingUser.ValidateExistingUser();
			if(isLoginSuccessful==false) {
				RentalApplication.main(null);
			}
			else {
				CarRental.rentCar(isLoginSuccessful);
			}
			break;
		case 2:
			NewUser.registerNewUser();
			break;
		default:
            System.out.println("Invalid choice.");
		}
		scanner.close();
	}
	
	public static void main(String[] args) {

		getStart();
		
		
	}
}
