package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List <Jet> jets = new ArrayList <> ();
	
	public void airField() {
	}

	public void createJets() {
		//Begin loading planes from file
				File f = new File("Jets.txt");
				Jet jet;
				int numJets = 0;
				
				//System.out.println("inside create jets"); TODO delete when testing is complete
				
				try (BufferedReader br = new BufferedReader(new FileReader(f))){
					String line;
					String[] arr;
					while ((line = br.readLine()) != null) {
						//numJets = 0;
						arr = line.split(",");
						String jetType = arr[0];
						String model = arr[1];
						int speed = (Integer.parseInt(arr[2]));
						int range = (Integer.parseInt(arr[3]));
						double price = (Double.parseDouble(arr[4]));
						if (jetType.equalsIgnoreCase("cargo plane")){
							jet = new CargoPlane(model, speed, range, price);
							jets.add(jet);
						}
						else if (jetType.equalsIgnoreCase("fighter jet")) {
							jet = new FighterJet(model, speed, range, price);
							jets.add(jet);
						}
					}
					//*************************
					//System.out.println(" Printing jets in array for error check, comment out when done" 
					//		+ jets.toString());
					// TODO delete when testing is complete
					//*************************
					
					System.out.println("Your jets have been loaded!");
				} catch (FileNotFoundException e) {
					System.err.println("Invalid filename: " + e.getMessage());
				} catch (IOException e) {
					System.out.println(e);
		
				}
	
	}

	public void fly() {
		Jet currentJet;
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(jets.get(i));
		currentJet = jets.get(i);
		double maxTimeOfFlight = (double)(currentJet.getRange() / currentJet.getSpeed());
		System.out.println(currentJet.getModel() 
				+ " can fly " + maxTimeOfFlight + " hours before needing to refuel.");
		
		}
		
	}

	public void listJets() {
		//System.out.println(jets);
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(jets.get(i));
			
		}
		
	}

	public void viewFastestJet() {
		Jet fastestJet = jets.get(0);
		Jet currentJet;
		
		for (int i = 0; i < jets.size(); i++) {
		currentJet = jets.get(i);
			if(currentJet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = currentJet;
			}
		}
		System.out.println("The fastest jet in the fleet is the " + fastestJet.getModel() 
		+ ". It's specifications are: \n\t" + fastestJet.toString());
		
	}

	public void viewJetWithLongestRange() {
		Jet rangeJet = jets.get(0);
		Jet currentJet;
		
		for (int i = 0; i < jets.size(); i++) {
		currentJet = jets.get(i);
			if(currentJet.getRange() > rangeJet.getRange()) {
				rangeJet = currentJet;
			}
		}
		System.out.println("The jet with the longest range in the fleet is the " + rangeJet.getModel() 
		+ ". It's specifications are: \n\t" + rangeJet.toString());
		
	}

	public void loagAllCargoJets() { //TODO fix typo
		for (int i = 0; i < jets.size(); i++) {
				if(jets.get(i) instanceof CargoPlane ) {
					System.out.println("Loading the " + jets.get(i).getModel() + ".");
					((CargoCarrier) jets.get(i)).loadCargo();
				}
			}
		
	}

	public void dogFight() {
		for (int i = 0; i < jets.size(); i++) {
			if(jets.get(i) instanceof FighterJet ) {
				System.out.println("Scramble the " + jets.get(i).getModel() + "!!");
				((FighterJet) jets.get(i)).fight();
			}
		}
	
		
	}

	public void addJetToFleet(Scanner kb) {
		kb.nextLine();
		System.out.println("Adding a new jet.");
		System.out.println("Please enter the model type: ");
		String model = kb.nextLine();
		System.out.println("Please enter the model max speed: ");
		int speed = kb.nextInt();
		System.out.println("Please enter the model range: ");
		int range = kb.nextInt();
		System.out.println("Please enter the model price: ");
		double price = kb.nextDouble();
		Jet newJet = new PassengerJet(model, speed, range, price);
		jets.add(newJet);
		
	}

	public void removeJetFromFleet(Scanner kb) {
		System.out.println("Please choose a jet to remove");
		int num = 1;
		for (int i = 0; i < jets.size(); i++) {
			System.out.println( num + ".) " + jets.get(i));
			num++;
		}
		System.out.println("Enter the number of the jet you would like to remove: ");
		int toRemove = kb.nextInt() - 1;
		Jet removed = jets.remove(toRemove);
		System.out.println(removed.getModel() + " has been removed. The airfield currently contains: ");
		listJets();
		
	}
}
