package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);
	 
	public static void main(String[] args) {
		JetsApplication run = new JetsApplication();
		run.launch();

	}
	private void launch() {
		System.out.println("Welcome! We are loading your jets now.");
		airField.createJets();
		boolean quit = false;
		
		while (!quit) {
		System.out.println("Please select from the menu items below:");
		displayUserMenu();
		System.out.println("Please enter your selection by number: ");
		int selection = kb.nextInt();
		quit = determineChoice(selection);
		
		}
		
		

		
	}
	private boolean determineChoice(int selection) {
		boolean quit = false;
		if (selection == 1) {
			airField.listJets();
		} else if (selection == 2) {
			airField.fly();		
		} else if (selection == 3) {
			airField.viewFastestJet();
		} else if (selection == 4) {
			airField.viewJetWithLongestRange();
		} else if (selection == 5) {
			airField.loagAllCargoJets();
		} else if (selection == 6) {
			airField.dogFight();
		} else if (selection == 7) {
			airField.addJetToFleet(kb);
		} else if (selection == 8) {
			airField.removeJetFromFleet(kb);
		} else if (selection == 9) {
			System.out.print("Quitting application");
			quit = true;
		} else {
			System.out.println("Invalid selection. Please try again or choose 9 to quit.");
			
		}
		kb.nextLine();
		return quit;
		
	}
	private void displayUserMenu() {
		System.out.println("1.) List fleet\n"
						 + "2.) Fly all jets\n"
						 + "3.) View fastest jet\n"
						 + "4.) View jet with longest range\n"
						 + "5.) Load all Cargo Jets\n"
						 + "6.) Dogfight!\n"
						 + "7.) Add a jet to Fleet\n"
						 + "8.) Remove a jet from Fleet\n"
						 + "9.) Quit");
		
	}
	private void listPlanes() {
		
	}

}
