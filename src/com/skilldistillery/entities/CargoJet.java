package com.skilldistillery.entities;

public class CargoJet extends Jet implements ICargoCarrier, IResearch{
	
	public CargoJet(String model, int speed, int range, long price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
		System.out.println(model + " is flying slowly and steadily for "+getFlightTime()+ " hours.");
	}
	
	public void loadCargo() {
		System.out.println(model + " loading cargo as requested!");
		
	}
	
	public void researchPayload() {
		System.out.println(model + " has been configured to conduct research and is launching with scientific instruments.");
	}
	
	

}
