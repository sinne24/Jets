package com.skilldistillery.jets.entities;

public interface CombatReady {
	public default void fight() {
		System.out.println("Engaging enemy. Target locked.");
	}
}
