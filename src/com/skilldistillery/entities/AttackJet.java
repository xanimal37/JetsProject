package com.skilldistillery.entities;

public class AttackJet extends Jet implements IFighter{
	
	public AttackJet(String model, int speed, int range, long price) {
		this.model = model;
		this.speed=speed;
		this.range = range;
		this.price = price;
	}
	
	@Override
	public void fly() {
		System.out.println(model + " is in the sky! Look out below! It can attack for "+getFlightTime()+" hours.");
	}
	
	public void scramble() {
		System.out.println(model + " is helping the fighters in the dogfight!");
	}
}
