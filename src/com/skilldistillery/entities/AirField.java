package com.skilldistillery.entities;

import java.util.List;

public class AirField {

	private List<Jet> fleet;
	
	//public method to add a jet to the fleet
	public void addToFleet(Jet jet) {
		fleet.add(jet);
	}
	
	//public method to get the fastest jet
	public Jet getFastest() {
		return null;
	}
	
	//public method to get the jet with the longest range
	public Jet getLongestRanged() {
		return null;
	}
	
	//public method to fly all jets
	public void airShow() {
		System.out.println("Flying all jets! Watch out below it's an airshow!");
		for(Jet jet : fleet) {
			jet.fly();
		}
	}
	
	//public method to remove a jet from the fleet
	public void removeJet() {
		//implement with input from a menu
	}
}
