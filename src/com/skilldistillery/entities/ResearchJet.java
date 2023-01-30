package com.skilldistillery.entities;

public class ResearchJet extends Jet implements IResearch {
	
	public ResearchJet(String model, int speed, int range, long price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	@Override
	public void fly() {
		System.out.println(model +" is conducting valuable scientific research! It can conduct research for "+ getFlightTime() + " hours.");
	}
	
	public void researchPayload() {
		System.out.println(model + " is conducting a research mission.");
	}

}
