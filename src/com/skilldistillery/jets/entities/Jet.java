package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private double price;
	
	public Jet(String model, int speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	public void fly() {
		System.out.println(); //TODO prints out the jet details and the amount of time the jet can 
							  //fly until it runs out of fuel (based on speed and range).
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet model: " + model + ", speed: " + speed + "mph, range: " + range + ", price: $" + price + "";
	}
	
	

}
