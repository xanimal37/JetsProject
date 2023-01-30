package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private ArrayList<Jet> fleet;
	
	//constructor (no no args constcutor)
	public AirField() {
		fleet = new ArrayList<Jet>();
	}

	// public method to add a jet to the fleet
	public void addToFleet(Jet jet) {
		fleet.add(jet);
	}
	
	//creates jet
	public void createJets(String type, String model, double speed,int range,long price) {
		
		//determine the type of jet based on the first element
		switch(type) {
		case "Research":
			//System.out.println("Adding a RESEARCH jet!");
			Jet researchJet = new ResearchJet(model,speed,range,price);
			addToFleet(researchJet);
			break;
		case "Attack":
			//System.out.println("Adding a ATTACK jet!");
			Jet attackJet = new AttackJet(model,speed,range,price);
			addToFleet(attackJet);
			break;
		case "Cargo":
			//System.out.println("Adding a CARGO jet!");
			Jet cargoJet = new CargoJet(model,speed,range,price);
			addToFleet(cargoJet);
			break;
		case "Passenger":
			//System.out.println("Adding a PASSENGER jet!");
			Jet passengerJet = new PassengerJet(model,speed,range,price);
			addToFleet(passengerJet);
			break;
		case "Fighter":
			//System.out.println("Adding a FIGHTER jet!");
			Jet fighterJet = new FighterJet(model,speed,range,price);
			addToFleet(fighterJet);
			break;
		default:
			break;
		}
	}

	// public method to get the fastest jet
	public void getFastest() {
		Jet fastestJet = null;
		double fastestSpeed = 0;

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
		double bestRange = 0;

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
		long price= input.nextLong();
		
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
