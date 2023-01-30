package com.skilldistillery.entities;

public class PassengerJet extends Jet implements ICargoCarrier {

	public PassengerJet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	@Override
	public void fly() {
		System.out.println(model + " is flying quickly to get the passengers home on time! It can travel for "+getFlightTime() + " hours.");
	}
	
	public void loadCargo() {
		System.out.println(model + " has been configured for cargo and is being loaded");
	}
}
