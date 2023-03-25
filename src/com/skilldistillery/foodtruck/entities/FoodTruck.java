package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private int truckId;
	private int rating;
	private String foodType;
	private String name;	


	//constructors	
	public FoodTruck (int truckId, String name, String foodType, int rating ) {
		this.truckId = truckId;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	

	//toString method
	@Override
	public String toString() {
		return "FoodTruck [truckId=" + truckId + ", rating=" + rating + ", foodType=" + foodType + ", name=" + name
				+ "]";
	
	}


	public int getTruckId() {
		return truckId;
	}


	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
