package com.skilldistillery.entities;

public abstract class Jet {

	protected String model;
	protected int speed;
	protected int range;
	protected double price;
	
	//setters
	protected void setModel(String model) {
		this.model = model;
	}
	
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	protected void setRange(int range) {
		this.range = range;
	}
	
	protected void setPrice(double price) {
		this.price = price;
	}
	
	//getters
	protected String getModel() {
		return model;
	}
	
	protected int getSpeed() {
		return speed;
	}
	
	protected int getRange() {
		return range;
	}
	
	//use this to calculate flight time for the jet
	protected double getFlightTime() {
		double flightTime = getRange()/getSpeed();
		return flightTime;
	}
	
	
	//this method must be overridden by every jet
	public abstract void fly();
	
	public String toString() {
		return model +" - " + speed + " mph - " + range + " miles - $" + price;
	}
}
