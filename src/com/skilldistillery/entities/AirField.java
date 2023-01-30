package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class AirField {

	private ArrayList<Jet> fleet;

	public AirField() {
		fleet = new ArrayList<Jet>();
	}

	// public method to add a jet to the fleet
	public void addToFleet(Jet jet) {
		fleet.add(jet);
	}

	// public method to get the fastest jet
	public void getFastest() {
		Jet fastestJet = null;
		int fastestSpeed = 0;

		for (Jet j : fleet) {
			if (j.getSpeed() > fastestSpeed) {
				fastestSpeed = j.getSpeed();
				fastestJet = j;
			}
		}
		System.out.println(fastestJet);
	}

	// public method to get the jet with the longest range
	public void getLongestRanged() {
		Jet longestRange = null;
		int bestRange = 0;

		for (Jet j : fleet) {
			if (j.getRange() > bestRange) {
				bestRange = j.getSpeed();
				longestRange = j;
			}
		}
		System.out.println(longestRange);
	}

	// public method to fly all jets
	public void airShow() {
		System.out.println("Flying all jets! Watch out below it's an airshow!");
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	// public method to remove a jet from the fleet
	public void removeJet() {
		// implement with input from a menu
	}

	// show all jets
	public void displayFleet() {
		for (Jet j : fleet) {
			System.out.println(j);
		}
	}

	// load cargo jets
	public void loadCargoJets() {
		for (Jet j : fleet) {
			if (j instanceof ICargoCarrier) {
				((ICargoCarrier) j).loadCargo();
			}
		}
	}
	
	//scramble anything that can fight!
	public void scrambleJets() {
		for(Jet j: fleet) {
			if(j instanceof IFighter) {
				((IFighter)j).scramble();
			}
		}
	}
	
	//input data to ad a jet to the fleet
	public void addAJet(Scanner input) {
		System.out.println("Enter the jet model: ");
		String model = input.nextLine();
		System.out.println("Enter the jet's speed: ");
		int speed = input.nextInt();
		System.out.println("Enter the jet's range: ");
		int range= input.nextInt();
		System.out.println("Enter the jet's price: ");
		double price= input.nextDouble();
		
		Jet newJet = new JetImpl(model,speed,range,price);
		
		addToFleet(newJet);
	}
	
	//remove jet
	public void removeAJet(Scanner input) {
		Jet jetToRemove = null;
		System.out.println("Which model would you like to remove?");
		String mod = input.nextLine();
		for(Jet j:fleet) {
			if(j.getModel().equals(mod)) {
				jetToRemove=j;
				break;
			}
		}
		fleet.remove(jetToRemove);
	}
	
	//fly research jets
	public void flyResearchJets() {
		
		for(Jet j: fleet) {
			if(j instanceof IResearch) {
				((IResearch)j).researchPayload();
			}
		}
	}
}
