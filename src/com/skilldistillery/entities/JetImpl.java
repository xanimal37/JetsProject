package com.skilldistillery.entities;

public class JetImpl extends Jet {
	
	public JetImpl(String model, int speed, int range, double price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
		System.out.println(model + " is flying. It can fly for " + getFlightTime()+" hours.");
	}

}
