package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();

		FoodTruck[] fleet = new FoodTruck[5];

		fta.run(fleet);
	}

	public void run(FoodTruck[] fleet) {
		System.out.println("Get ready to Rate some Food Trucks!");

		boolean quit = false;
		int counter = 0;
		while (quit == false && counter < 5) {
			for (int truck = 0; truck < fleet.length; truck++) {
				int truckId = truck + 1;
				System.out.println("\nEnter Food Truck number " + truckId);

				System.out.println("What is the Name of the Food Truck?");
				String name = sc.next();
				if (name.equals("quit")) {
					quit = true;
					break;
				}

				System.out.println("What type of food does this truck serve? ");
				String type = sc.next();

				System.out.println("On a scale of 1-3 (3 being the best) " + "what rating would you give this truck? ");
				int rating = sc.nextInt();

				while (rating > 3 || rating < 1) {
					System.out.println("not a valid rating you must enter number between 1 and 3");
					rating = sc.nextInt();
				}

				fleet[truck] = new FoodTruck(truckId, name, type, rating);

				// System.out.println(fleet[truck].toString());
				counter++;
			}
		}
		if (quit == true || counter >= 5) {
			menu(fleet);
		}
		sc.close();
	}

	public void exit() {
		System.out.println("Thank you for rating Food Trucks!!!");

	}

	public void menu(FoodTruck[] fleet) {
		while (true) {
			System.out.println(" *********************************************" + "\n 1. List Food Trucks"
					+ "\n 2. View Average Rating of Food Trucks" + "\n 3. View Highest Rated Food Truck" + "\n 4. Quit "
					+ "\n *********************************************");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				// LIST
				System.out.println(truckNames(fleet));
				break;
			case 2:
				// AVERAGE RATING
				System.out.println(avgRating(fleet));
				break;
			case 3:
				System.out.println(topRating(fleet));
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("not a valid entry.");
			}
		}
	}

	public String truckNames(FoodTruck[] fleet) {
		String names = "";
		for (int truck = 0; truck < fleet.length; truck++) {
			if (fleet[truck] != null) {
				names += fleet[truck].getName() + "\n";
			}
		}
		return names;
	}

	public double avgRating(FoodTruck[] fleet) {
		double totalRating = 0.0;
		int numTrucks = 0;
		for (int truck = 0; truck < fleet.length; truck++) {
			if (fleet[truck] != null) {
				totalRating += fleet[truck].getRating();
				numTrucks++;
			}
		}
		return totalRating / numTrucks;
	}

	public FoodTruck topRating(FoodTruck[] fleet) {
		FoodTruck topRated = null;
		int nextRate = 0;
		for (int truck = 0; truck < fleet.length; truck++) {
			if (fleet[truck] != null) {
				if (fleet[truck].getRating() > nextRate) {
					nextRate = fleet[truck].getRating();
					topRated = fleet[truck];
				}
			}
		}
		return topRated;
	}

}
