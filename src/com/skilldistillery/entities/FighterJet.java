package com.skilldistillery.entities;

public class FighterJet extends Jet implements IFighter {

	public FighterJet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	@Override
	public void fly() {
		System.out.println(model + " is screaming through the sky! It can soar like this for "+ getFlightTime()+" hours.");
		
	}
	
	public void scramble() {
		System.out.println(model + " is scrambling for a dogfight!!!");
	}
	
	
}
