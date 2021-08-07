package com.skilldistillery.jets.entities;

public interface CargoCarrier {
	public default void loadCargo() {
		System.out.println("Loading Cargo!");
		System.out.println("Watch those forks! You punch a hole on my fuselage, I'll punch a hole in your skull!");
	}

}
